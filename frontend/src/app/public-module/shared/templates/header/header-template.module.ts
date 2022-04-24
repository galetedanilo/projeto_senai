import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HeaderTemplateComponent } from './header-template.component';

@NgModule({
  declarations: [HeaderTemplateComponent],
  imports: [CommonModule, RouterModule],
  exports: [HeaderTemplateComponent],
})
export class HeaderTemplateModule {}
