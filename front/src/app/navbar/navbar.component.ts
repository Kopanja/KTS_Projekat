import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../services/authentication.service';
import { Router } from '@angular/router';
import {LogedInUser} from '../model/loged-in-user.model';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public logedInUser : LogedInUser;

  public isLogedIn : boolean;

  constructor(private authenticationService:AuthenticationService, private router : Router) { }

  ngOnInit(): void {
    this.isLogedIn = this.authenticationService.isLoggedIn();
    this.logedInUser = this.authenticationService.getCurrentUser();
    //this.authenticationService.isLogedIn.subscribe(bool => this.isLogedIn = bool);
    //this.authenticationService.logedInUser.subscribe(user => this.logedInUser = user);

    console.log(this.isLogedIn);
    console.log(this.logedInUser);

  }

  logOut(){
    this.authenticationService.logout();
    
    
  }


}
