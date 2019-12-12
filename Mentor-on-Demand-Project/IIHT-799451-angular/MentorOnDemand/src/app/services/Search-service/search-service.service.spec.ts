import { TestBed } from '@angular/core/testing';

import { SearchServiceService } from './search-service.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('SearchServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]}));

  it('should be created', () => {
    const service: SearchServiceService = TestBed.get(SearchServiceService);
    expect(service).toBeTruthy();
  });
});
