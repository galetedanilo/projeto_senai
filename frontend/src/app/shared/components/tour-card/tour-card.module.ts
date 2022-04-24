import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { TourCardReviewComponent } from './components/tour-card-review/tour-card-review.component';
import { TourCardComponent } from './tour-card.component';

@NgModule({
  declarations: [TourCardComponent, TourCardReviewComponent],
  imports: [CommonModule],
  exports: [TourCardComponent],
})
export class TourCardModule {}
