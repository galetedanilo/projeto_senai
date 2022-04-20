import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { IGRUDService } from './interfaces/grud-service.interface';

@Injectable()
export class GRUDService implements IGRUDService {
  constructor(private httpClient: HttpClient) {}

  public load<T>(url: string): Observable<T[]> {
    return this.httpClient.get<T[]>(url);
  }

  public create<T, R>(url: string, record: T): Observable<R> {
    return this.httpClient.post<R>(url, record);
  }

  public update<T, R>(url: string, record: T): Observable<R> {
    return this.httpClient.put<R>(url, record);
  }

  public remove<R>(url: string, id: number): Observable<R> {
    return this.httpClient.delete<R>(`${url}/${id}`);
  }
}
