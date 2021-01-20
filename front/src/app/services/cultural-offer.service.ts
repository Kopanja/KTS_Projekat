import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {CulturalOffer} from '../model/cultural-offer.model'
import { CoApplicationForm } from '../model/co-application-form.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CulturalOfferService {

  private readonly path = "http://localhost:8080/api/cultural-offer";
  private readonly applicatonFormPath = "http://localhost:8080/api/application-forms";
  constructor(private http : HttpClient) { }

  getAll():Observable<CulturalOffer[]>{
    return this.http.get<CulturalOffer[]>("http://localhost:8080/api/cultural-offer");
    
  }

  getAllAplicationForms():Observable<CoApplicationForm[]>{
    return this.http.get<CoApplicationForm[]>(this.applicatonFormPath);
  }
  applyForOffer(applicationForm : CoApplicationForm){
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.applicatonFormPath, JSON.stringify(applicationForm ), {headers});

  }

  approveOffer(id : number){
    return this.http.get(this.applicatonFormPath + '/' + id + '/accept');
  }

  rejectOffer(id : number){
    return this.http.delete(this.applicatonFormPath + '/' + id + '/reject');
  }


}
