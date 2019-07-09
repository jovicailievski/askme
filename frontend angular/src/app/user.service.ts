import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IUser } from './interface/user';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  _loginUrl = "http://localhost:8080/login";
  _registerUrl = "http://localhost:8080/rest/register";
  _getLoggedUserInfo = "http://localhost:8080/rest/user";

  constructor(private http: HttpClient,private cookieService:CookieService) { }

  registerUser( user:IUser){
    let param = new HttpParams().set("username",user.username).set("password",user.password);
    return this.http.post<any>(this._registerUrl,param);
  }

  loginUser( user:IUser){
    let param = new HttpParams().set("username",user.username).set("password",user.password);
    // let value = this.cookieService.get("JSESSIONID");
    // // this.cookieService.set("JSESSIONID",value)
    // let header = new HttpHeaders()
    // .set("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
    // .set("Accept-Encoding","gzip, deflate, br")
    // .set("Accept-Language","en-US,en;q=0.9")
    // .set("JSESSIONID",value);
    return this.http.post<any>(this._loginUrl,param);
  }
}
