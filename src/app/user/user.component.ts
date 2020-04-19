import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthUserService } from '../login-user/auth-user.service';
import { RideRegistrationService } from '../register-ride-detail/ride-registration.service';
import { DisplayRideService } from '../display-rides/display-ride.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {


  rideDetails:any;
  origin:string;
  destination:string;
  isLoggedIn = false;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private authenticationUserService: AuthUserService,
    private service:DisplayRideService) { }

  ngOnInit(): void {
    let resp = this.service.getAllRides();
    resp.subscribe((data)=>this.rideDetails=data);
  }

  public findRideByOrigin(origin){
    let resp = this.service.getByOrigin(origin);
    resp.subscribe((data)=>this.rideDetails=data);
  }

  public findRideByDestination(destination){
    let resp = this.service.getByDestination(destination);
    resp.subscribe((data)=>this.rideDetails=data);
  }

  handleLogout(){
    this.authenticationUserService.logout();
  }

}
