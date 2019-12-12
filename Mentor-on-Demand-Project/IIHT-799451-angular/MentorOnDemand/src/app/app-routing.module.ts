import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { AddSkillComponent } from './skills/add-skill/add-skill.component';
import { MentorDetailsComponent } from './mentor-details/mentor-details.component';
import { SearchComponent } from './Search/search/search.component';
import { MentorHomeComponent } from './mentor-home/mentor-home.component';
import { MentorAddSkillComponent } from './mentor/mentor-add-skill/mentor-add-skill.component';
import { MentorGuardService } from './services/mentor-guard/mentor-guard.service';



const routes: Routes = [

 
  { path: 'signup', component: SignupComponent},
{ path: 'login',component: LoginComponent},
{ path: 'addSkill',component:AddSkillComponent},
{ path: 'mentorDetails',component:MentorDetailsComponent},
{ path: 'search-bar',component:SearchComponent},
{ path: 'mentorpage',component:MentorHomeComponent,canActivate: [MentorGuardService]},
{path:'MentorAddSkill',component:MentorAddSkillComponent,canActivate: [MentorGuardService]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
