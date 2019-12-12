import { Injectable } from '@angular/core';
import { Skill } from 'src/app/model/Skill';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchServiceService {

  constructor(private httpClient:HttpClient) { }



  findMentorBySkill(skill:Skill):Observable<any> {
    return this.httpClient.post<any>(`${environment.baseUrl}` + 'search-microservice/mentorBySkill',skill);
  }



  
}
