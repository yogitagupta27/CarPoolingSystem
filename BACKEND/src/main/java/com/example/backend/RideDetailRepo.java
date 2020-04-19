package com.example.backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RideDetailRepo extends JpaRepository<RideDetails,Integer>{

	List<RideDetails> findByOrigin(String origin);

	List<RideDetails> findByDestination(String destination);

}