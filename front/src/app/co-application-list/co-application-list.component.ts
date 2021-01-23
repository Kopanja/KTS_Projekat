import { Component, OnInit } from '@angular/core';
import {CulturalOfferService} from '../services/cultural-offer.service';
import { CoApplicationForm } from '../model/co-application-form.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-co-application-list',
  templateUrl: './co-application-list.component.html',
  styleUrls: ['./co-application-list.component.css']
})
export class CoApplicationListComponent implements OnInit {

  public applicationFormList : CoApplicationForm[];

  constructor(private culturalOfferService : CulturalOfferService, private router : Router) { }

  ngOnInit(): void {
    this.culturalOfferService.getAllAplicationForms().subscribe(data=>{
      this.applicationFormList = data;
    })
  }

  moreButton(id : number){
    this.router.navigate(['/review-applications', id]);
  }
  approveButton(id : number){
      this.culturalOfferService.approveOffer(id).subscribe();
      
  }

  rejectButton(id : number){
    this.culturalOfferService.rejectOffer(id).subscribe();
  }

}
