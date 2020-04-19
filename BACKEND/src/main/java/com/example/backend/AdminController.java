package com.example.backend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @CrossOrigin("http://localhost:4200/")
    @PostMapping("/admin/addUser")
    public String addUser(@RequestBody Users user) {
        String pwd = user.getPassword();
        String encryptedPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptedPwd);
        userRepo.save(user);
        return "Successfully Registered..!!";
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/admin/getAllUsers")
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/admin/findUser/{email}")
    public List<Users> findUserByEmail(@PathVariable String email) {
        return userRepo.findByEmail(email);
    }

    @CrossOrigin("http://localhost:4200/")
    @PutMapping("/admin/update/{id}")
    public Optional<Object> updateUser(@PathVariable int id, @RequestBody Users user) {
        return userRepo.findById(id)
        .map(mapper->{
            mapper.setUsername(user.getUsername());
            mapper.setEmail(user.getEmail());
            String pwd = user.getPassword();
            String encryptedPwd = passwordEncoder.encode(pwd);
            mapper.setPassword(encryptedPwd);
            Users updated = userRepo.save(mapper);
            ResponseEntity.ok().body(updated);
            return "User Updated";
        });
    }

    @CrossOrigin("http://localhost:4200/")
    @DeleteMapping("/admin/deleteUser/{id}")    
    public List<Users> deleteUser(@PathVariable int id){
        userRepo.deleteById(id);
        return userRepo.findAll();
    }

}