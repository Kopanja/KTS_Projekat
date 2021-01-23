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

  getTypeById(id : number):Observable<Type>{
    return this.http.get<Type>(this.typePath+ '/' + id);
  }

  updateSubType(subType : SubType){
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put(this.typePath +'/' + subType.parentType.id + this.addSubTypePath + '/' + subType.id, JSON.stringify(subType), {headers});
  }

  updateType(type : Type){
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put(this.typePath +'/' + type.id, JSON.stringify(type), {headers});
  }

  deleteSubType(subType : SubType){
    return this.http.delete(this.typePath +'/' + subType.parentType.id + this.addSubTypePath + '/' + subType.id);
  }

  addNewSubType(parentId : number, name : string){
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.typePath +'/' + parentId + this.addSubTypePath, JSON.stringify({"name" : name}), {headers});
  }
}
