import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { RouterModule } from '@angular/router';

import { UserSettingMenuComponent } from './components/user-setting-menu/user-setting-menu.component';
import { HeaderTemplateComponent } from './header-template.component';

@NgModule({
  declarations: [HeaderTemplateComponent, UserSettingMenuComponent],
  imports: [
    CommonModule,
    RouterModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
  ],
  exports: [HeaderTemplateComponent],
})
export class HeaderTemplateModule {}
