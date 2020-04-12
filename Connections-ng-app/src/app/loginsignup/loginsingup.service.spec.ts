import { TestBed } from '@angular/core/testing';

import { LoginsingupService } from './loginsignup.service';

describe('LoginsingupService', () => {
  let service: LoginsingupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginsingupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
