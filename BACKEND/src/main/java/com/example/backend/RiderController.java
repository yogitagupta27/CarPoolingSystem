package com.example.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiderController {

    @Autowired
    private RiderRepo riderRepo;
    
    @Autowired
    private RideDetailRepo rideDetailRepo;
    
    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/riders/getRider")
    public List<Rider> getAllRider() {
        return riderRepo.findAll();
    }

    @CrossOrigin("http://localhost:4200/")
    @PostMapping("/riders/addRideDetails")
    public String addRide(@RequestBody RideDetails rideDetail){
        rideDetailRepo.save(rideDetail);
        return "Ride Details added succesfully";
    } 
}