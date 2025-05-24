import { TestBed } from '@angular/core/testing';

import { AppBackEndService } from './app-back-end.service';

describe('AppBackEndService', () => {
  let service: AppBackEndService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppBackEndService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
