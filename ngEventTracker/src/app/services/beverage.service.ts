import { Beverage } from './../models/beverage';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BeverageService {
  private url = 'http://localhost:8083/api/beverages';

  constructor(private http: HttpClient, private router: Router) { }

  index() {
    // return this.http.get<Beverage[]>(this.url + '?sorted=true')
    return this.http.get<Beverage[]>(this.url)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('BeverageService.index() Error');
        })
      );
  }

  create(newBev: Beverage) {
    newBev.active = true;
    newBev.containsAlcohol = false;
    newBev.ingredients = '';

    console.log(newBev);

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };

    return this.http.post<Beverage>(this.url, newBev, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log('Error in create' + err);
          return throwError('BeverageService.create() Error');
        })
      );
  }

  update(editBev: Beverage) {
    const id = editBev.id;

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };

    return this.http.put<Beverage>(this.url + '/' + id, editBev, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log('Error in update' + err);
          return throwError('BeverageService.update() Error');
        })
      );
  }

  destroy(id: number) {
    return this.http.delete<Beverage>(this.url + '/' + id)
      .pipe(
        catchError((err: any) => {
          console.log('Error in delete' + err);
          return throwError('BeverageService.delete() Error');
        })
      );
  }

}
