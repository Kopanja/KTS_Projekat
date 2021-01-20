import { Component, OnInit } from '@angular/core';
import { TypeService } from '../services/type.service';
import {Type, SubType} from '../model/type.model';
import { CoApplicationForm } from '../model/co-application-form.model';
import { CulturalOfferService } from '../services/cultural-offer.service'
@Component({
  selector: 'app-cultural-offer-application',
  templateUrl: './cultural-offer-application.component.html',
  styleUrls: ['./cultural-offer-application.component.css']
})
export class CulturalOfferApplicationComponent implements OnInit {

  public types : Type[];
  public subTypes : SubType[];

  public coApplication : CoApplicationForm;
  public selectedType : Type;
  public selectedSubType : SubType;
  constructor(private typeService : TypeService, private culturalOfferService : CulturalOfferService) { 
    this.coApplication = {email : "", name: "", type: "", subType: ""}
  }

  ngOnInit(): void {
    this.typeService.getAllTypes().subscribe(data => {
      this.types = data;
    })
  }

  typeSelected(type:Type){
    this.typeService.getAllSubTypesFromParent(type.id).subscribe(data =>{
      this.subTypes = data;
    })
    
  }

  applyClicked(){
    this.coApplication.type = this.selectedType.name;
    this.coApplication.subType = this.selectedSubType.name;

    this.culturalOfferService.applyForOffer(this.coApplication).subscribe();
  }

}
