import { TestBed } from '@angular/core/testing';

import { SkillServiceService } from './skill-service.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('SkillServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]}));

  it('should be created', () => {
    const service: SkillServiceService = TestBed.get(SkillServiceService);
    expect(service).toBeTruthy();
  });
});
