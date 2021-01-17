import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtUtilService } from './jwt-util.service';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private readonly loginPath = 'http://localhost:8080/api/auth/log-in';

  constructor(private http: HttpClient, private jwtUtilService: JwtUtilService) { }

  login(email: string, password: string): Observable<boolean> {
    console.log(email);
    console.log(password);
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.loginPath, JSON.stringify({ email, password }), { headers }).pipe(
      map((res: any) => {
        let token = res && res['accessToken'];
        console.log(res);
        if (token) {
          console.log("USAO");
          localStorage.setItem('currentUser', JSON.stringify({
            email: email,
            roles: this.jwtUtilService.getRoles(token),
            token: res['accessToken']
          }));
          console.log("GOTOV");
          return true;
        }
        else {
          return false;
        }
      }));
  }

  getToken(): String {
    
    var currentUser = JSON.parse(JSON.parse(JSON.stringify(localStorage.getItem('currentUser'))));
    var token = currentUser.token;
    console.log(token);
    return token ? token : "";
  }

  logout(): void {
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    if (this.getToken() != "") return true;
    else return false;
  }

  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(localStorage.currentUser);
    }
    else {
      return undefined;
    }
  }

}
