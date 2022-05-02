import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatSidenavModule } from '@angular/material/sidenav';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { HeaderTemplateModule } from './shared/templates/header/header-template.module';
import { NavbarTemplateModule } from './shared/templates/navbar/navbar-template.module';

@NgModule({
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    HeaderTemplateModule,
    NavbarTemplateModule,
    MatSidenavModule,
  ],
  exports: [AdminComponent],
})
export class AdminModule {}
