import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CulturalOfferApplicationComponent } from './cultural-offer-application.component';

describe('CulturalOfferApplicationComponent', () => {
  let component: CulturalOfferApplicationComponent;
  let fixture: ComponentFixture<CulturalOfferApplicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CulturalOfferApplicationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CulturalOfferApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
