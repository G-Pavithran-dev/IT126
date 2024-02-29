package com.veggievibes.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String doorno;
    private String street;
    private String city;
    private String landmark;
    private String address1;
    private String address2;
    private String mobilenumber;
    private String pincode;

    @JsonBackReference
    @JoinColumn(name = "credential_id")
    @OneToOne
    private UserCredentials userCredentials;
}
