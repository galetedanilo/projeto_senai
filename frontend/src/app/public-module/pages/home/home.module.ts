import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { TourCardModule } from '../../../shared/components/tour-card/tour-card.module';
import { ITourCardService } from '../../../shared/services/tour-card-service/interfaces/tour-card-service.interface';
import { TourCardService } from '../../../shared/services/tour-card-service/tour-card.service';
import { PromotionsComponent } from './components/promotions/promotions.component';
import { HomeComponent } from './home.component';

@NgModule({
  declarations: [HomeComponent, PromotionsComponent],
  imports: [CommonModule, TourCardModule],
  exports: [HomeComponent],
  providers: [
    {
      provide: ITourCardService,
      useClass: TourCardService,
    },
  ],
})
export class HomeModule {}
