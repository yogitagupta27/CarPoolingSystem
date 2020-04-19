import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuardService } from './auth-guard.service';
import { SearchDeleteComponent } from './search-delete/search-delete.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { UserComponent } from './user/user.component';
import { SignupComponent } from './signup/signup.component';
import { RiderComponent } from './rider/rider.component';
import { SignupRiderComponent } from './signup-rider/signup-rider.component';
import { AuthGuardRiderService } from './rider/auth-guard-rider.service';
import { RegisterRideDetailComponent } from './register-ride-detail/register-ride-detail.component';


const routes: Routes = [
  {path:"" , redirectTo:"home" , pathMatch:"full"},
  {path:"signup" , component:SignupComponent},
  {path:"signupRider" , component:SignupRiderComponent},
  {path:"home" , component:HomeComponent},
  {path:"adminLogin" , component:LoginComponent},
  {path:"riderLogin" , component:RiderComponent},
  {path:"userLogin" , component:LoginUserComponent},
  {path:"yourHome" , component:UserComponent , canActivate:[AuthGuardService]},
  {path:"register" , component:RegisterComponent, canActivate: [AuthGuardService] },
  {path:"search" , component:SearchDeleteComponent , canActivate: [AuthGuardService]},
  {path:"offerRide" , component:RegisterRideDetailComponent , canActivate:[AuthGuardRiderService]},
  {path: 'logout', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
