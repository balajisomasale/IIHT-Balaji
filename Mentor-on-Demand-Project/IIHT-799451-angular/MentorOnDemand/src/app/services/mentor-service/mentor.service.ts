import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Mentor } from 'src/app/model/Mentor';
import { environment } from 'src/environments/environment';
import { Mentor_Skill } from 'src/app/model/Mentor_Skill';
import { Skill } from 'src/app/model/Skill';

@Injectable({
  providedIn: 'root'
})
export class MentorService {

  constructor( private httpClient: HttpClient) { }


  Mentor: Mentor = null;
  
  addNewMentor(mentor: Mentor): Observable<any> {

    return this.httpClient.post(`${environment.baseUrl}` + 'user-service/mentor/addMentor', mentor)
  }




  addNewMentorSkill(AddmentorSkill: Mentor_Skill): Observable<any> {

    return this.httpClient.post<any>(`${environment.baseUrl}` + 'user-service/mentor/addMentorSkill', AddmentorSkill)
  }

  findMentorBySkill(skill:Skill):Observable<any> {
    return this.httpClient.post(`${environment.baseUrl}` + 'search-microservice/mentorBySkill',skill);
  }

}
