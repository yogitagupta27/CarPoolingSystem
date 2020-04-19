package com.example.backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer>{

	Users findByUsername(String username);

	List<Users> findByEmail(String email);

}