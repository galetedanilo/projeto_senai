import { Observable } from 'rxjs';

export abstract class IGRUDService {
  abstract load<T>(): Observable<T[]>;

  abstract create<T, R>(record: T): Observable<R>;

  abstract update<T, R>(record: T): Observable<R>;

  abstract remove<R>(id: number): Observable<R>;
}
