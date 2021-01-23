import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypesTableComponent } from './types-table.component';

describe('TypesTableComponent', () => {
  let component: TypesTableComponent;
  let fixture: ComponentFixture<TypesTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TypesTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TypesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
