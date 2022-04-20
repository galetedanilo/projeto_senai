import { Component, Input, OnInit } from '@angular/core';
import { faStar, faStarHalf } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'tour-card-review',
  templateUrl: './tour-card-review.component.html',
  styleUrls: ['./tour-card-review.component.scss'],
})
export class TourCardReviewComponent implements OnInit {
  @Input() stars: number = 0;
  @Input() reviews: number = 0;
  faStar = faStar;
  faStarHalf = faStarHalf;
  starArray: number[] = [];
  starHalf: number = 0;

  ngOnInit(): void {
    this.starsRender();
  }

  private starsRender(): void {
    this.starArray = Array.from({ length: this.stars });
    this.starHalf = this.stars % 1;
  }
}
