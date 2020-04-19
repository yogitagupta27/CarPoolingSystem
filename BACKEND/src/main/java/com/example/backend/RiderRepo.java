package com.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepo extends JpaRepository<Rider,Integer>{

	Rider findByUsername(String username);



}