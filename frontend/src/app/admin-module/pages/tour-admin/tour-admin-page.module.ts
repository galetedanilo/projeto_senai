import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IGRUDService } from 'src/app/core/services/interfaces/grud-service.interface';

import { TourAdminFormComponent } from './components/tour-admin-form.component';
import { TourAdminService } from './services/tour-admin.service';
import { TourAdminPageComponent } from './tour-admi-page.component';

@NgModule({
  declarations: [TourAdminPageComponent, TourAdminFormComponent],
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  exports: [TourAdminPageComponent],
  providers: [{ provide: IGRUDService, useClass: TourAdminService }],
})
export class TourAdminPageModule {}
