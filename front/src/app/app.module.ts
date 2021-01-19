import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { MainPageComponent } from './main-page/main-page.component';
import { MapComponentComponent } from './map-component/map-component.component';
import { CulturalOfferComponent } from './cultural-offer/cultural-offer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FiltersComponent } from './filters/filters.component';
@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    LoginComponent,
    MainPageComponent,
    MapComponentComponent,
    CulturalOfferComponent,
    NavbarComponent,
    FiltersComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
