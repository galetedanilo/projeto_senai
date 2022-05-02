import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IGRUDService } from 'src/app/core/services/interfaces/grud-service.interface';
import { API_RESOURCES } from 'src/app/infra/http/api-resources';
import { API_URL } from 'src/app/infra/http/api-url';

@Injectable()
export class TourAdminService implements IGRUDService {
  constructor(private httpClient: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  url: string = `${API_URL.V1}/${API_RESOURCES.TOUR_ADMIN}`;

  load<T>(): Observable<T[]> {
    throw new Error('Method not implemented.');
  }
  create<ITourAdminRequest, ITourAdminResponse>(
    record: ITourAdminRequest
  ): Observable<ITourAdminResponse> {
    return this.httpClient.post<ITourAdminResponse>(
      this.url,
      record,
      this.httpOptions
    );
  }
  update<T, R>(record: T): Observable<R> {
    throw new Error('Method not implemented.');
  }
  remove<R>(id: number): Observable<R> {
    throw new Error('Method not implemented.');
  }
}
