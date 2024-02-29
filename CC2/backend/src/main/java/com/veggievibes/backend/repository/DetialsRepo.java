package com.veggievibes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veggievibes.backend.model.UserDetails;

public interface DetialsRepo extends JpaRepository<UserDetails, Integer> {
    
}
