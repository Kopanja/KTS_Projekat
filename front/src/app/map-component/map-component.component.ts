import { Component, OnInit } from '@angular/core';
import { MapService } from '../services/map.service';
import { GeoJson, FeatureCollection } from '../model/map';
import * as mapbox from 'mapbox-gl';
import { environment } from 'src/environments/environment';
import { Location } from '../model/location.model';
import { listen } from 'ol/events';
import { listLazyRoutes } from '@angular/compiler/src/aot/lazy_routes';
import { map } from 'rxjs/operators';
@Component({
  selector: 'app-map-component',
  templateUrl: './map-component.component.html',
  styleUrls: ['./map-component.component.css']
  
})
export class MapComponentComponent implements OnInit {

  map: mapboxgl.Map;
  style = 'mapbox://styles/mapbox/light-v10';
  lat = 44.7866;
  lng = 20.4489;
  message = 'Hello World!';

  source: any;
  markers: any;

  constructor(private mapService: MapService) { }
  
  ngOnInit(): void {
    this.markers = this.mapService.getAll();
    this.initializeMap();
  }

  private initializeMap() {
    /// locate the user
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(position => {
       this.lat = position.coords.latitude;
       this.lng = position.coords.longitude;
       this.map.flyTo({
         center: [this.lng, this.lat]
         
       })
     });
   }
    this.buildMap()

  }

  buildMap() {
    this.map = new mapbox.Map({
      accessToken: environment.mapbox.accessToken,
      container: 'map',
      style: this.style,
      zoom: 13,
      center: [this.lng, this.lat]
      
    });


    /// Add map controls
    this.map.addControl(new mapbox.NavigationControl());


    //// Add Marker on Click
    this.map.on('click', (event) => {
      const coordinates = [event.lngLat.lng, event.lngLat.lat]
      console.log(coordinates);
      const newMarker   = new GeoJson(coordinates, { message: this.message })
      //this.mapService.createMarker(newMarker)
    })


    /// Add realtime firebase data on map load
    this.map.on('load', (event) => {
      
      /// register source
      this.map.addSource('firebase', {
         type: 'geojson',
         data: {
           type: 'FeatureCollection',
           features: []
         }
      });

      this.source = this.map.getSource('firebase');
      this.markers.subscribe((markers: Location[]) =>{
        let data = new FeatureCollection(this.createGeoJsonList(markers))
        this.source.setData(data);
        //let geoJsonList = this.createGeoJsonList(markers);
        //this.createMarkers(geoJsonList);
      })

      

      /// create map layers with realtime data
      
      this.map.addLayer({
        id: 'firebase',
        source: 'firebase',
        type: 'symbol',
        layout: {
          'text-field': '{message}',
          'text-size': 12,
          'text-transform': 'uppercase',
          'icon-image': '{icon}',
          'text-offset': [0, 1.5],
          
        },
        paint: {
          'text-color': '#f16624',
          'text-halo-color': '#fff',
          'text-halo-width': 2,
        }
      
      })

    
    })
  }


  /// Helpers

  createGeoJsonList(locations : Location[]) : GeoJson[] {
    let lista : GeoJson[] = [];
    locations.forEach(location => {
      lista.push(new GeoJson([location.longitude, location.latitude], { message: "muzej", icon:'museum-15', iconSize : [40, 40]}));
    });

    return lista;
  }

  createMarkers(locations: GeoJson[]){
    locations.forEach(location => {
      let el = document.createElement('div');

      el.addEventListener('click', function(){
        window.alert(location.properties.message)
      })
      //el.id = 'nesto';
      
      let newMarker = new mapbox.Marker(el).setLngLat([location.geometry.coordinates[0], location.geometry.coordinates[1]]).addTo(this.map);
    })
  }
  
}
