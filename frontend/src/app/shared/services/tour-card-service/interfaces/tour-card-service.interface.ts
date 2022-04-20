import { Observable } from 'rxjs';

import { ITourCard } from '../../../interfaces/tour-card.interface';

export abstract class ITourCardService {
  abstract getAllPromotions(): Observable<ITourCard[]>;
}
