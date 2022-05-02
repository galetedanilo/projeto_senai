import { Component } from '@angular/core';

@Component({
  selector: 'app-user-setting-menu',
  templateUrl: './user-setting-menu.component.html',
  styleUrls: ['./user-setting-menu.component.scss'],
})
export class UserSettingMenuComponent {
  constructor() //private matDialog: MatDialog
  {}

  public onUserSettingModal(): void {
    //this.matDialog.open(UserSettingModelComponent, { disableClose: true });
  }
}
