import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Type, SubType } from '../model/type.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TypeService {

  private readonly typePath = "http://localhost:8080/api/category-types";
  private readonly addSubTypePath = '/sub-types';
  constructor(private http : HttpClient) { }


  getAllTypes():Observable<Type[]>{
    return this.http.get<Type[]>(this.typePath);
    
  }

  getAllSubTypesFromParent(parentId : number):Observable<SubType[]>{
    return this.http.get<SubType[]>(this.typePath + '/' + parentId + this.addSubTypePath);
  }
}
