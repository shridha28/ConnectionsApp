import { TestBed } from '@angular/core/testing';

import { LoginsignupService } from './loginsignup.service';

describe('LoginsingupService', () => {
  let service: LoginsignupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginsignupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
