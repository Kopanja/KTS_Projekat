import { Component, OnInit } from '@angular/core';
import { Type } from '../model/type.model';
import { TypeService } from '../services/type.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-types-table',
  templateUrl: './types-table.component.html',
  styleUrls: ['./types-table.component.css']
})
export class TypesTableComponent implements OnInit {

  public types : Type[];

  constructor(private typeService : TypeService, private router: Router) { }

  ngOnInit(): void {
    this.typeService.getAllTypes().subscribe(data => this.types = data);
  }

  editTypeButton(id: number){
    this.router.navigate(['/edit-type', id]);
  }

}
