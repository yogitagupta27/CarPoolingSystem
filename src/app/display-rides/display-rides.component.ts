import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthUserService } from '../login-user/auth-user.service';
import { DisplayRideService } from './display-ride.service';

@Component({
  selector: 'app-display-rides',
  templateUrl: './display-rides.component.html',
  styleUrls: ['./display-rides.component.css']
})
export class DisplayRidesComponent implements OnInit {

  isLoggedIn = false;
  message: any;
  rideDetails: any;

  constructor(private router: Router,
              private authenticationService:AuthUserService,
              private service: DisplayRideService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log('menu-> ' + this.isLoggedIn);

    let resp = this.service.getAllRides();
    console.log(resp);
    resp.subscribe((data)=>this.rideDetails=data)
  }

  handleUserLogout(){
    this.authenticationService.logout();
  }

  
}
