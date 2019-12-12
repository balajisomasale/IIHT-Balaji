import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

import { Observable } from 'rxjs';
import { User } from 'src/app/model/User';
import { AuthServiceService } from '../Authentication-service/auth-service.service';
import { SkillServiceService } from '../Skill-service/skill-service.service';
import { Mentor } from 'src/app/model/Mentor';
import { MentorService } from '../mentor-service/mentor.service';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private router:Router,private http:HttpClient,private authservice:AuthServiceService,private skillservice:SkillServiceService,private mentorservice:MentorService) { }
Mentor:Mentor=null;
private displayName:string = null;
private currentUserName:string = null;
private currentUser:User = null;
  userExists:boolean=false;

error:String;

  addUser(user:any) {

let NewUsers:User={id:user["id"],firstName:user["firstName"],lastName:user["lastName"],password:user["password"], userName: user['userName'], contactNumber: user['contactNumber'], role:user['role'],
regCode:user["regCode"],resetPassword:user["resetPassword"],resetPasswordDate:user["resetPasswordDate"],
};
this.addUsers(NewUsers).subscribe(data=>
  {

    if(user.role=="user")
    {
    this.userExists=data;   
      this.userExists=false;
       console.log("inside if user service"+this.userExists);
    
  this.router.navigate(['login']);
    }
    else{
      this.mentorservice.Mentor={id:null,linkedinURL:null,yearsOfExperience:null,timeslot:null,user:user}
      this.router.navigate(['mentorDetails']);
    
    }
    
  },
  error=>{


      if (error.status == 500) {
        this.error = "User Already Exists";
        // this.userCreated = false;
    this.userExists=true;
    console.log(error);}
    console.log(this.error)
      }
  )

}
  


addUsers(user:User):Observable<any>
{

  return this.http.post<User>(environment.baseUrl+"user-service/users",user)
}
getUser():Observable<any> {
  return this.http.get(environment.baseUrl+"user-service/users/"+this.authservice.username);
}
getCurrentUserFromDataBase() {
  console.log(this.authservice.username);
  
  this.getUser().subscribe(
    (data)=>{
      this.currentUser = data;
      console.log(this.currentUser)
    },
    (error)=>{
      console.log(error);
      
    }
  )
}

getCurrentUser():User {
  return this.currentUser;
}
setCurrentUser(currentUser:User) {
  this.currentUser = currentUser;
}
getCurrentUserName():string {
  return this.currentUserName;
}
setCurrentUserName(currentUserName:string) {
  this.currentUserName = currentUserName;
}
getDisplayName():string {
  return this.displayName;
}
setDisplayName(displayName:string) {
  this.displayName = displayName;
}

}
