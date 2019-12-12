import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from './services/Authentication-service/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'MentorOnDemand';


  constructor(private authService: AuthServiceService, public router: Router) {
  }

  ngOnInit(): void {
    this.router.navigate(['/search-bar']);


  }

  isLoggedIn: boolean = false;
  role: String;

  loggedIn(): boolean {
    if (!this.authService.loggedInUser.loggedOut) {
      this.isLoggedIn = true;


      return true
    }
    else {
      this.isLoggedIn = false;
      return false;
    }
  }
}
