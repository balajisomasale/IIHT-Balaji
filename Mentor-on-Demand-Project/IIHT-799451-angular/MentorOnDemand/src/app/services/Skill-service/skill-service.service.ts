import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthServiceService } from '../Authentication-service/auth-service.service';
import { environment } from 'src/environments/environment';
import { Skill } from 'src/app/model/Skill';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Mentor } from 'src/app/model/Mentor';
import { Mentor_Skill } from 'src/app/model/Mentor_Skill';

@Injectable({
  providedIn: 'root'
})
export class SkillServiceService {


  //Mentor: Mentor = null;
  isLoggedIn: Boolean = false;
  constructor(private authservice: AuthServiceService, private httpClient: HttpClient) { }




  getAllSkills(): Observable<any> {

    return this.httpClient.get(`${environment.baseUrl}` + 'user-service/skills')
    }
  
}


