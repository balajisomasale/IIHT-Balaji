import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Skill } from 'src/app/model/Skill';
import { SkillServiceService } from 'src/app/services/Skill-service/skill-service.service';
import { TrainingService } from 'src/app/services/training-service/training.service';
import { UserServiceService } from 'src/app/services/user service/user-service.service';
import { AuthServiceService } from 'src/app/services/Authentication-service/auth-service.service';

@Component({
  selector: 'app-mentor-add-skill',
  templateUrl: './mentor-add-skill.component.html',
  styleUrls: ['./mentor-add-skill.component.css']
})
export class MentorAddSkillComponent implements OnInit {

  skillForm: FormGroup;
  skillList: Skill[] = [];
  errorMessage: string = null;

  constructor(private skillService:SkillServiceService, private formBuild: FormBuilder, private trainingService:TrainingService, private userService:UserServiceService,private authservice:AuthServiceService) { }

  ngOnInit() {
    
    this.errorMessage = null;
    this.buildSkillForm()
    this.skillList = [];
    this.skillService.getAllSkills().subscribe(
      (data) => {
        this.skillList = data;
      },
      (error) => {
        console.log(error);
      }
    )
  }
  buildSkillForm() {
    this.skillForm = this.formBuild.group({
      skill: ['', [
        Validators.required
      ]],
      selfRating: ['', [
        Validators.required,
        Validators.max(10),
        Validators.min(0)
      ]],
      yearsExperience: ['', [
        Validators.required,
        Validators.min(0),
        // Validators.
      ]],
    })
  }
  get skill() {
    return this.skillForm.get('skill');
  }
  get selfRating() {
    return this.skillForm.get('selfRating');
  }
  get yearsExperience() {
    return this.skillForm.get('yearsExperience');
  }
  addSkill(formData:any) {
    let skill:Skill = this.skillList.find(skill => skill.name == formData["skill"]);
    let yearsExperience:number = formData["yearsExperience"];
    let selfRating:number = formData["selfRating"];
    this.trainingService.addMentorSkillAfterLogin(skill,this.authservice.username,yearsExperience,selfRating).subscribe(
      (data) => {
        
        window.alert("Your details are submitted successfully");
        this.buildSkillForm();
      },
      (error) => {
        console.log(error);
        if (error.error.message == "This skill exists for this mentor") {
          this.errorMessage = "This skill exists for this mentor";
        }
      }
    );

}

}
