import { Component, OnInit } from '@angular/core';
import { CulturalOffer } from '../model/cultural-offer.model';
import { CulturalOfferService } from '../services/cultural-offer.service';

@Component({
  selector: 'app-cultural-offer',
  templateUrl: './cultural-offer.component.html',
  styleUrls: ['./cultural-offer.component.css']
})
export class CulturalOfferComponent implements OnInit {

  public culturalOffers : CulturalOffer[];
  constructor(private culturalOfferService: CulturalOfferService){ }
  ngOnInit(): void {
     this.culturalOfferService.getAll().subscribe(data =>{this.culturalOffers = data})
  }
}
