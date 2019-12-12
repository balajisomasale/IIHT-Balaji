import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/Skill';
import { SkillServiceService } from 'src/app/services/Skill-service/skill-service.service';
import { Mentor_Skill } from 'src/app/model/Mentor_Skill';
import { MentorService } from 'src/app/services/mentor-service/mentor.service';
import { UserServiceService } from 'src/app/services/user service/user-service.service';

@Component({
  selector: 'app-add-skill',
  templateUrl: './add-skill.component.html',
  styleUrls: ['./add-skill.component.css']
})
export class AddSkillComponent implements OnInit {


  constructor(private fb:FormBuilder,private router:Router,private skillService:SkillServiceService,private mentorservice:MentorService,private userservice:UserServiceService) { }
  signupForm:FormGroup;
  skillList:Skill[] = [];




  ngOnInit() {
    this.buildsignupForm()
 
    this.skillList=[];
    this.skillService.getAllSkills().subscribe(data=>{
      this.skillList=data;
   
    })
  }

  buildsignupForm(){
    this.signupForm = this.fb.group({
      skill:['',[
        Validators.required
      ]],
      selfRating:['',[
        Validators.required]],
        yearsOfExperience: ['', [
        Validators.required]],
    })
  }
  get skill() {
    return this.signupForm.get('skill');
  }
  get selfRating() {
    return this.signupForm.get('selfRating');
  }
  get yearsOfExperience() {
    return this.signupForm.get('yearsOfExperience');
  }

  addSkill(skillForm:any){
    let mentorSkill:Mentor_Skill={mentor:this.userservice.Mentor,selfRating:skillForm['selfRating'],yearsOfExperience:skillForm['yearsOfExperience'],
                                    skill:this.skillList.find(skill=>skill.name == skillForm["skill"])}


    this.mentorservice.addNewMentorSkill(mentorSkill).subscribe(data=>{
      this.buildsignupForm();
      alert("Additional Skills added");
    

      console.log("inside subscribe "+this.buildsignupForm())
    })

  }

}
