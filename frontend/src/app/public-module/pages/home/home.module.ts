import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { TourCardSkeletonModule } from 'src/app/shared/templates/tour-card-skeleton/tour-card-skeleton.module';
import { TourCardModule } from 'src/app/shared/components/tour-card/tour-card.module';

import { ITourCardService } from '../../../shared/services/tour-card-service/interfaces/tour-card-service.interface';
import { TourCardService } from '../../../shared/services/tour-card-service/tour-card.service';
import { PromotionsComponent } from './components/promotions/promotions.component';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';

@NgModule({
  declarations: [HomeComponent, PromotionsComponent],
  imports: [
    CommonModule,
    TourCardModule,
    TourCardSkeletonModule,
    HomeRoutingModule,
  ],
  providers: [
    {
      provide: ITourCardService,
      useClass: TourCardService,
    },
  ],
})
export class HomeModule {}
