import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DisplayRideService {

  rideDetails: any;
  origin:string;
  destination:string;

  constructor(private http:HttpClient) { }

  public getAllRides(){
    return this.http.get("http://localhost:8080/users/getRideDetails");
  }

  public getByOrigin(origin){
    return this.http.get("http://localhost:8080/users/getRideDetailsO/" + origin);
  }

  public getByDestination(destination){
    return this.http.get("http://localhost:8080/users/getRideDetailsD/" + destination);
  }
}
