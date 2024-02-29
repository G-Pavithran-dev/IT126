package com.veggievibes.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veggievibes.backend.model.UserCredentials;
import com.veggievibes.backend.model.UserDetails;
import com.veggievibes.backend.repository.CredentialsRepo;
import com.veggievibes.backend.repository.DetialsRepo;

@Service
public class UserServices {
    
    @Autowired
    private CredentialsRepo credentialsRepo;

    @Autowired
    private DetialsRepo detailsRepo;

    public boolean signup(UserCredentials userCredentials)
    {
        try
        {
            credentialsRepo.save(userCredentials);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public UserCredentials searchUserByEmail(String email)
    {
        return credentialsRepo.findByEmail(email).orElse(null);
    }

    public List<UserCredentials> getAllUsers()
    {
        return credentialsRepo.findAll();
    }

    public boolean saveUser(UserDetails userDetails)
    {
        try
        {
            detailsRepo.save(userDetails);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
}