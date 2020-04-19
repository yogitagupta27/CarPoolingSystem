package com.example.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RiderRepo riderRepo;

    @Autowired
    private RideDetailRepo rideDetailRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(){
        return "HOME";
    }

    @GetMapping("/users/list")
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/signup")
    public String addUser(@RequestBody Users user){
        String pwd = user.getPassword();
        String encryptedPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptedPwd);
        userRepo.save(user);
        return "Successfully Registered..!!";
    }

    @PostMapping("/addRider")
    public String addUser(@RequestBody Rider rider) {
        String pwd = rider.getRider_password();
        String encryptedPwd = passwordEncoder.encode(pwd);
        rider.setRider_password(encryptedPwd);
        riderRepo.save(rider);
        return "Successfully Registered..!!";
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/users/getRideDetails")
    public List<RideDetails> getRideDetails() {
        return rideDetailRepo.findAll();
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/users/getRideDetailsO/{origin}")
    public List<RideDetails> getRidesByOrigin(@PathVariable String origin) {
        return rideDetailRepo.findByOrigin(origin);
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/users/getRideDetailsD/{destination}")
    public List<RideDetails> getRidesByDestination(@PathVariable String destination) {
        return rideDetailRepo.findByDestination(destination);
    }
}