import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';

import { NavbarTemplateComponent } from './navbar-template.component';

@NgModule({
  declarations: [NavbarTemplateComponent],
  imports: [CommonModule, MatIconModule],
  exports: [NavbarTemplateComponent],
})
export class NavbarTemplateModule {}
