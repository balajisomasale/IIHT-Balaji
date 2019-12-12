import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../../services/user service/user-service.service';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { AuthServiceService } from 'src/app/services/Authentication-service/auth-service.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;
  user: User;
  userCreated: boolean;
  // error: string;


  rolesData=["user","Mentor"];
  
  constructor(private formBuilder: FormBuilder,private userService:UserServiceService,private authservice:AuthServiceService,private router:Router) { }
  get userName() {
    return this.signUpForm.get('userName');
  }
  get firstName() {
    return this.signUpForm.get('firstName');
  }
  get lastName() {
    return this.signUpForm.get('lastName');
  }
  get role() {
    return this.signUpForm.get('role');
  }

  get contactNumber() {
    return this.signUpForm.get('contactNumber');
  }

  // get linkedinUrl() {
  //   return this.signUpForm.get('linkedinUrl');
  // }

  // get yearsOfExperience() {
  //   return this.signUpForm.get('yearsOfExperience');
  // }

  get password() {
    return this.signUpForm.get('password');
  }
  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      userName: ['', [
        Validators.required,
        this.isuserNameTaken
      ]],
      firstName: ['', [
        Validators.required,Validators.min(3),Validators.max(25)
      ]],
      lastName: ['', [
        Validators.required
      ]],
      role: ['', [
        Validators.required
      ]],
      // linkedinUrl: ['', [
      //   Validators.required
      // ]],
      contactNumber: ['', [
        Validators.required,Validators.min(1000000000),Validators.max(9999999999)
      ]],
      // yearsOfExperience: ['', [
      //   Validators.required
      // ]],
   
      password: ['', [
        Validators.required
      ]],
      confirmPassword: ['', [
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]]
    })
  }

  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }

  isuserNameTaken(formControl: FormControl): { [s: string]: boolean } {
    if (formControl.value === 'admin') {
      return { 'userNameTaken': true };
    } else {
      return null;
    }
  }

  routetoSkill()
  {

    if(this.authservice.role=='USER'){
   this.router.navigate(['login'])  }

   else {
    this.router.navigate(['mentorDetails']) 
   }
    }


}
