import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerPreferenceComponent } from './customer-preference.component';

describe('CustomerPreferenceComponent', () => {
  let component: CustomerPreferenceComponent;
  let fixture: ComponentFixture<CustomerPreferenceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerPreferenceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerPreferenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
