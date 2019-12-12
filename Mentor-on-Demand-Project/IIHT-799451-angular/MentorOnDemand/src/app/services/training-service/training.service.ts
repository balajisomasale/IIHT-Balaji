import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Training } from 'src/app/model/Training';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserServiceService } from '../user service/user-service.service';
import { Skill } from 'src/app/model/Skill';
import { AuthServiceService } from '../Authentication-service/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {
 

  constructor(private http:HttpClient,private userService:UserServiceService,private authservice:AuthServiceService) { }

  sendTrainingRequest(training:Training):Observable<any> {
    console.log(training)
    return this.http.post(`${environment.baseUrl}` + 'Training-service/addTrainingRequest',training);
  }


  getIncompleteTrainingObservable():Observable<any> {
   
    return this.http.get(`${environment.baseUrl}` + 'Training-service/getIncompleteTraining/'+this.authservice.username);
  }

  saveStatusChangedTraining(training:Training):Observable<any> {

    return this.http.post(`${environment.baseUrl}` + 'Training-service/editStatus/', training);
  }
  
  addMentorSkillAfterLogin(skill:Skill,userName:string,yearsExperience:number,selfRating:number):Observable<any> {
    // let headers = new HttpHeaders();
    // headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());
    return this.http.post(`${environment.baseUrl}` + 'Training-service/addSkillLogin/'+userName+"/"+yearsExperience+"/"+selfRating+"/", skill);
  }
}
