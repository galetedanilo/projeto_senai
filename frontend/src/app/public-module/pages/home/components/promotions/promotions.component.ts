import { Component, OnInit, SkipSelf } from '@angular/core';
import { Observable } from 'rxjs';
import { ITourCard } from 'src/app/shared/interfaces/tour-card.interface';
import { ITourCardService } from 'src/app/shared/services/tour-card-service/interfaces/tour-card-service.interface';

@Component({
  selector: 'tour-promotions',
  templateUrl: './promotions.component.html',
  styleUrls: ['./promotions.component.scss'],
})
export class PromotionsComponent implements OnInit {
  public tourCardList$!: Observable<ITourCard[]>;

  constructor(@SkipSelf() private tourCardService: ITourCardService) {}

  ngOnInit(): void {
    this.tourCardList$ = this.tourCardService.getAllPromotions();
  }
}
