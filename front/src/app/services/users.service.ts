import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {User} from '../model/user.model'
@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private readonly path = "http://localhost:8080/api/users";
  constructor(private http : HttpClient) { }

  getAll():Observable<User[]>{
    return this.http.get<User[]>("http://localhost:8080/api/users");
    
  }
}
