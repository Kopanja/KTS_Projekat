import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TypeService } from '../services/type.service';
import { Type, SubType } from '../model/type.model';

@Component({
  selector: 'app-edit-type',
  templateUrl: './edit-type.component.html',
  styleUrls: ['./edit-type.component.css']
})
export class EditTypeComponent implements OnInit, OnDestroy {
  public id : number;
  private sub : any;
  public type : Type;
  public subTypes : SubType[];
  public isInputDisabled : boolean;
  public newSubType : string;
  public editTypeName : string;
  constructor(private route : ActivatedRoute, private typeService : TypeService) { }

  ngOnInit(): void {
    this.isInputDisabled = true;
    this.sub = this.route.params.subscribe(params => {
      this.id =+ params['id'];
      this.typeService.getTypeById(this.id).subscribe(data => {this.type = data});
      this.typeService.getAllSubTypesFromParent(this.id).subscribe(data => {this.subTypes = data});
      
    })
    
  }

  editButton(){
    this.isInputDisabled = false;
  }

  deleteButton(subType : SubType){
    this.typeService.deleteSubType(subType).subscribe(data=>{console.log(data)});
  }

  saveButton(subType : SubType){
    this.typeService.updateSubType(subType).subscribe(data => {console.log(data)})
  }

  cancelButton(){
    this.isInputDisabled = true;
    window.location.reload();
  }

  addNewSubTypeButton(){
    this.typeService.addNewSubType(this.type.id, this.newSubType).subscribe(data=>{console.log(data)})
  }

  editTypeButton(){
    this.type.name = this.editTypeName;
    this.typeService.updateType(this.type).subscribe(data=>{console.log(data)})
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
