import { Component, Input, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  public user: any;
  
  public wrongUsernameOrPass:boolean;

  constructor(private authenticationService:AuthenticationService,
    private router: Router) {
    this.user = {};
    this.wrongUsernameOrPass = false;
     }

  ngOnInit(): void {
  }

  login():void{
    
    this.authenticationService.login(this.user.email, this.user.password).subscribe(
      (loggedIn:boolean) => {
        if(loggedIn){
          console.log('Uspelo');
          //this.router.navigate(['/main']);          
        }
      }
    ,
    (err:Error) => {
      if(err.toString()==='Ilegal login'){
        this.wrongUsernameOrPass = true;
        console.log(err);
      }
      else{
        console.log("Ovaj Neki error");
        Observable.throw(err);
      }
    });
  }

  isLogedIn():void{
    console.log(this.authenticationService.getCurrentUser());
    console.log(this.authenticationService.isLoggedIn());
    
  }

}
