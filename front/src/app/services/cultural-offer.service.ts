import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {CulturalOffer} from '../model/cultural-offer.model'

@Injectable({
  providedIn: 'root'
})
export class CulturalOfferService {

  private readonly path = "http://localhost:8080/api/cultural-offer";
  constructor(private http : HttpClient) { }

  getAll():Observable<CulturalOffer[]>{
    return this.http.get<CulturalOffer[]>("http://localhost:8080/api/cultural-offer");
    
  }
}
