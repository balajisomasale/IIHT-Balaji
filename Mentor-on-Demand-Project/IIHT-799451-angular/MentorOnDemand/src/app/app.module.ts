import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './site/login/login.component';
import { SignupComponent } from './site/signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { MentorDetailsComponent } from './mentor-details/mentor-details.component';
import { AddSkillComponent } from './skills/add-skill/add-skill.component';
import { SearchComponent } from './Search/search/search.component';
import { MentorHomeComponent } from './mentor-home/mentor-home.component';
import { MentorAddSkillComponent } from './mentor/mentor-add-skill/mentor-add-skill.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
   
    
    MentorDetailsComponent,
    AddSkillComponent,
    SearchComponent,
    MentorHomeComponent,
    MentorAddSkillComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    
    FormsModule,ReactiveFormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
