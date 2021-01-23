import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CoApplicationForm } from '../model/co-application-form.model';
import { CulturalOfferService } from '../services/cultural-offer.service';
@Component({
  selector: 'app-review-applications',
  templateUrl: './review-applications.component.html',
  styleUrls: ['./review-applications.component.css']
})
export class ReviewApplicationsComponent implements OnInit, OnDestroy {
  public id : number;
  private sub: any;
  public applicationForm : CoApplicationForm;

  constructor(private route : ActivatedRoute, private culturalOfferService : CulturalOfferService) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id =+ params['id'];
      this.culturalOfferService.getApplicationFormById(this.id).subscribe(data=>{this.applicationForm = data})  
    })
  }

  approveButton(){
    this.culturalOfferService.approveOffer(this.id).subscribe();
    
}

rejectButton(){
  this.culturalOfferService.rejectOffer(this.id).subscribe();
}

  ngOnDestroy(): void{
    this.sub.unsubscribe();
  }

}
