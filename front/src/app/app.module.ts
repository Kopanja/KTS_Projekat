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
import { SignUpComponent } from './sign-up/sign-up.component';
import { CulturalOfferApplicationComponent } from './cultural-offer-application/cultural-offer-application.component';
import { SuperAdminPageComponent } from './super-admin-page/super-admin-page.component';
import { CoApplicationListComponent } from './co-application-list/co-application-list.component';
import { TypesTableComponent } from './types-table/types-table.component';
import { EditTypeComponent } from './edit-type/edit-type.component';
import { ReviewApplicationsComponent } from './review-applications/review-applications.component';
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
    SignUpComponent,
    CulturalOfferApplicationComponent,
    SuperAdminPageComponent,
    CoApplicationListComponent,
    TypesTableComponent,
    EditTypeComponent,
    ReviewApplicationsComponent,
    
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
