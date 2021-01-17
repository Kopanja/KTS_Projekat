import { Component, Input, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { UsersService } from '../services/users.service';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  public users : User[];
  constructor(private userService: UsersService){ }
  ngOnInit(): void {
     this.userService.getAll().subscribe(data =>{this.users = data})
  }

}
