import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  public user : any;
  public newUser: any;
  constructor(private authenticationService:AuthenticationService) {
    this.user = {};
   }

  ngOnInit(): void {
  
  }

  signUp(){
    this.authenticationService.signUp(this.user.email, this.user.password).subscribe(data => {
      this.newUser = data;
      //ako mi bude trebalo nesto sa novokreiranim userom
    });
    
  }

}
