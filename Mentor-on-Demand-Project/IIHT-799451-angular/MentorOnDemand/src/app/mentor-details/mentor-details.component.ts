import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SkillServiceService } from '../services/Skill-service/skill-service.service';
import { UserServiceService } from '../services/user service/user-service.service';
import { MentorService } from '../services/mentor-service/mentor.service';

@Component({
  selector: 'app-mentor-details',
  templateUrl: './mentor-details.component.html',
  styleUrls: ['./mentor-details.component.css']
})
export class MentorDetailsComponent implements OnInit {


  constructor(private fb:FormBuilder,private router:Router,private skillService:SkillServiceService,private userservice:UserServiceService,private MentorService:MentorService) { }
  signupForm:FormGroup;


  ngOnInit() {this.signupForm=this.fb.group({
    linkedinURL:["",[Validators.required]],
    yearsOfExperience:["",[Validators.required]],
    timeslot:["",[Validators.required]]
    //Validators.min(11),Validators.max(11)
  });
}
get linkedinURL() {
  return this.signupForm.get('linkedinURL');
}
get yearsOfExperience() {
  return this.signupForm.get('yearsOfExperience');
}
get timeslot() {
  return this.signupForm.get('timeslot');
}

addMentor(MentorForm:any){

this.userservice.Mentor={
  linkedinURL: this.signupForm.value['linkedinURL'],
  timeslot:this.signupForm.value['timeslot'],
  yearsOfExperience:this.signupForm.value['yearsOfExperience'],
user:this.MentorService.Mentor.user

};




  
  this.MentorService.Mentor.linkedinURL=MentorForm['linkedinURL'];
  
  this.MentorService.Mentor.timeslot=MentorForm['timeslot'];
  this.MentorService.Mentor.yearsOfExperience=MentorForm['yearsOfExperience'];
  // console.log("Mentor have"+this.skillService.Mentor)
  this.MentorService.addNewMentor(this.MentorService.Mentor).subscribe(data=>{
    alert("Click okay to add Skills");
    this.router.navigate(['addSkill'])
  })

}


}
