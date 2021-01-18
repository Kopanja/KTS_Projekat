import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import { GeoJson } from '../model/map';
import * as mapboxgl from 'mapbox-gl';
import {HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MapService {

  private readonly path = "http://localhost:8080/api/cultural-offer/locations";
  constructor(private http : HttpClient) { 
   }

   getAll():Observable<Location[]>{
    return this.http.get<Location[]>(this.path);
    
  }
}
