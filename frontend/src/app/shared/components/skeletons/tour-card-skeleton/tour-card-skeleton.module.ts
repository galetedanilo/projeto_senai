import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { TourCardSkeletonComponent } from './tour-card-skeleton.component';

@NgModule({
  declarations: [TourCardSkeletonComponent],
  imports: [CommonModule],
  exports: [TourCardSkeletonComponent],
})
export class TourCardSkeletonModule {}
