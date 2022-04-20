import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { TourCardReviewComponent } from './components/tour-card-review/tour-card-review.component';
import { TourCardComponent } from './tour-card.component';

@NgModule({
  declarations: [TourCardComponent, TourCardReviewComponent],
  imports: [CommonModule, FontAwesomeModule],
  exports: [TourCardComponent],
})
export class TourCardModule {}
