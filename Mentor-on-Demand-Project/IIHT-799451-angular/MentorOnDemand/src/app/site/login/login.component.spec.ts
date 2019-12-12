import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

 it('form invalid when empty', () => {
    expect(component.loginForm.valid).toBeFalsy();
  });

  it('email field validity', () => {
    let errors = {};
    let email = component.loginForm.controls['username'];
    expect(email.valid).toBeFalsy();

    // Email field is required
    errors = email.errors || {};
    expect(errors['required']).toBeTruthy();

    // Set email to something
    email.setValue("test");
    errors = email.errors || {};
    expect(errors['required']).toBeFalsy();
        
  });
  it('password field validity', () => {
    let errors = {};
    let password = component.loginForm.controls['password'];
    expect(password.valid).toBeFalsy();

    // Email field is required
    errors = password.errors || {};
    expect(errors['required']).toBeTruthy();

    password.setValue("passwordpassword");
    errors = password.errors || {};
    expect(errors['required']).toBeFalsy();
   

    password.setValue("password");
    errors = password.errors || {};
    expect(errors['required']).toBeFalsy();
  
});
it('form valid when properly filled', () => {
  let email = component.loginForm.controls['username'];
  email.setValue("test@example.com");
  let password = component.loginForm.controls['password'];
  password.setValue("password");
  expect(component.loginForm.valid).toBeTruthy();
});
});
