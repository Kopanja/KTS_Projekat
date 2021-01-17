import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtUtilService {

  constructor() { }

  getRoles(token: string) {
    console.log("Usao za role");
    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    let decodedJwtData = JSON.parse(decodedJwtJsonData);
    console.log(decodedJwtData.role);
    return [decodedJwtData.role];
  }
}
