import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_RESOURCES } from 'src/app/infra/http/api-resources';
import { API_URL } from 'src/app/infra/http/api-url';

import { ITourCard } from '../../interfaces/tour-card.interface';
import { ITourCardService } from './interfaces/tour-card-service.interface';

@Injectable()
export class TourCardService implements ITourCardService {
  constructor(private httpClient: HttpClient) {}

  url: string = `${API_URL.V1}/${API_RESOURCES.TOUR_CARD_PROMOTIONS}`;

  getAllPromotions(): Observable<ITourCard[]> {
    return this.httpClient.get<ITourCard[]>(this.url);
  }
}
