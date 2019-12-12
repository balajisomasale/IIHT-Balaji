import { TestBed } from '@angular/core/testing';

import { UserServiceService } from './user-service.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('UserServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]}));

  it('should be created', () => {
    const service: UserServiceService = TestBed.get(UserServiceService);
    expect(service).toBeTruthy();
  });
});
