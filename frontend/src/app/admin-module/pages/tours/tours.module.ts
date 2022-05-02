import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { IGRUDService } from 'src/app/core/services/interfaces/grud-service.interface';

import { ToursFormComponent } from './components/tours-form.component';
import { TourAdminService } from './services/tour-admin.service';
import { ToursRoutingModule } from './tours-routing.module';
import { ToursComponent } from './tours.component';

@NgModule({
  declarations: [ToursComponent, ToursFormComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ToursRoutingModule,
    MatFormFieldModule,
    MatInputModule,
  ],
  providers: [{ provide: IGRUDService, useClass: TourAdminService }],
})
export class ToursModule {}
