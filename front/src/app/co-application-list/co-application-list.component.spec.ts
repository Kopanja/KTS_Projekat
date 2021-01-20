import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoApplicationListComponent } from './co-application-list.component';

describe('CoApplicationListComponent', () => {
  let component: CoApplicationListComponent;
  let fixture: ComponentFixture<CoApplicationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoApplicationListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoApplicationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
