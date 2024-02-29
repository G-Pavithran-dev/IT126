package com.veggievibes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veggievibes.backend.model.UserCredentials;
import java.util.Optional;


@Repository
public interface CredentialsRepo extends JpaRepository<UserCredentials, Integer>{
    
    public Optional<UserCredentials> findByEmail(String email);
}
