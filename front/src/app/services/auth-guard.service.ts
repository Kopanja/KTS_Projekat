import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from './authentication.service';
@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private auth : AuthenticationService, private router : Router) { }

  canActivate(route : ActivatedRouteSnapshot) : boolean{
    const expectedRole = route.data.expectedRole;
    let roles = this.auth.getCurrentUserRoles();
    console.log(roles);
    let isRoleCorrect = false;
    roles.forEach(role => {
      if(expectedRole === role[0].authority){
        isRoleCorrect = true;
      }
    });

    if (!this.auth.isAuthenticated() || !isRoleCorrect) {

      this.router.navigate(['/login-page']);
      return false;
    }
    return true;
  }
}
