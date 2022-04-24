import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { PublicRoutingModule } from './public-routing.module';
import { PublicComponent } from './public.component';
import { HeaderTemplateModule } from './shared/templates/header/header-template.module';

@NgModule({
  declarations: [PublicComponent],
  imports: [CommonModule, HeaderTemplateModule, PublicRoutingModule],
  exports: [PublicComponent],
})
export class PublicModule {}
