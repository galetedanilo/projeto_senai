import { Component, Input, OnInit } from '@angular/core';
import { ITourCard } from 'src/app/shared/interfaces/tour-card.interface';

@Component({
  selector: 'tour-card',
  templateUrl: './tour-card.component.html',
  styleUrls: ['./tour-card.component.scss'],
})
export class TourCardComponent implements OnInit{
  @Input() tourCard!: ITourCard

  ngOnInit(): void {
    console.log(this.tourCard)
  }
}
