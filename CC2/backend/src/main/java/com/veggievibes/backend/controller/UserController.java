package com.veggievibes.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veggievibes.backend.model.UserCredentials;
import com.veggievibes.backend.model.UserDetails;
import com.veggievibes.backend.services.UserServices;

@RestController
public class UserController {
    
    @Autowired
    private UserServices userServices;

    @PostMapping("/signup")
    public UserCredentials signup(@RequestBody UserCredentials userCredentials)
    {
        if(userServices.signup(userCredentials))
        {
            return userCredentials;
        }
        else
        {
            return null;
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password)
    {
        UserCredentials details = userServices.searchUserByEmail(email);
        if(details.getPassword().equals(password) && details != null)
        {
            return "Login Successful";
        }
        else
        {
            return "Login Failed. Recheck your crendentials.";
        }
    }

    @GetMapping("/users")
    public List<UserCredentials> getUsers()
    {
        return userServices.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDetails saveUser(@RequestBody UserDetails userDetails)
    {
        if(userServices.saveUser(userDetails))
        {
            return userDetails;
        }
        else
        {
            return null;
        }
    }
}
