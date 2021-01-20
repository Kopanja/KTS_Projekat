import { Component, OnInit } from '@angular/core';
import {CulturalOfferService} from '../services/cultural-offer.service';
import { CoApplicationForm } from '../model/co-application-form.model';
@Component({
  selector: 'app-co-application-list',
  templateUrl: './co-application-list.component.html',
  styleUrls: ['./co-application-list.component.css']
})
export class CoApplicationListComponent implements OnInit {

  public applicationFormList : CoApplicationForm[];

  constructor(private culturalOfferService : CulturalOfferService) { }

  ngOnInit(): void {
    this.culturalOfferService.getAllAplicationForms().subscribe(data=>{
      this.applicationFormList = data;
    })
  }

  approveButton(id : number){
      this.culturalOfferService.approveOffer(id).subscribe();
      
  }

  rejectButton(id : number){
    this.culturalOfferService.rejectOffer(id).subscribe();
  }

}
