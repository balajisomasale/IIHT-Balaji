import { TestBed } from '@angular/core/testing';

import { AuthGuardServiceService } from './auth-guard-service.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('AuthGuardServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]}));

  it('should be created', () => {
    const service: AuthGuardServiceService = TestBed.get(AuthGuardServiceService);
    expect(service).toBeTruthy();
  });
});
