import { Component } from '@angular/core';
import { User } from './model/user.model';
import usersData from './util/usersData';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';

  ngOnInit(){
    
  }
}
