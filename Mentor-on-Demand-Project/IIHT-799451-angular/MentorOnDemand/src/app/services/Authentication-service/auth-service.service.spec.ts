import { TestBed } from '@angular/core/testing';

import { AuthServiceService } from './auth-service.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('AuthServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]}));

  it('should be created', () => {
    const service: AuthServiceService = TestBed.get(AuthServiceService);
    expect(service).toBeTruthy();
  });
});
