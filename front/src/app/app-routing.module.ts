import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { CulturalOfferApplicationComponent } from './cultural-offer-application/cultural-offer-application.component';
import { SuperAdminPageComponent } from './super-admin-page/super-admin-page.component';
const routes: Routes = [
  {path: 'main-page', component: MainPageComponent},
  {path: 'login-page', component: LoginComponent},
  {path: 'signup-page', component: SignUpComponent},
  {path: 'co-application-page', component: CulturalOfferApplicationComponent},
  {path: 'super-admin-page', component: SuperAdminPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
