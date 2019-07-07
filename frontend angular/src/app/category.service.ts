import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ICategory } from './interface/category';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private _url="http://localhost:8080/rest/categories";

  constructor(private http: HttpClient) { }

  getCat():Observable<ICategory[]>{
    const a= this.http.get<ICategory[]>(this._url);
    console.log(a);
    return a;
  }
}
