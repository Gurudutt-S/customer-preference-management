import { TestBed } from '@angular/core/testing';

import { CustomerPreferenceService } from './customer-preference.service';

describe('CustomerPreferenceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerPreferenceService = TestBed.get(CustomerPreferenceService);
    expect(service).toBeTruthy();
  });
});
