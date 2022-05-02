import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header-template',
  templateUrl: './header-template.component.html',
  styleUrls: ['./header-template.component.scss'],
})
export class HeaderTemplateComponent {
  @Output() showSideMenu: EventEmitter<void> = new EventEmitter<void>();

  public onShowSideMenu(): void {
    this.showSideMenu.emit();
  }
}
