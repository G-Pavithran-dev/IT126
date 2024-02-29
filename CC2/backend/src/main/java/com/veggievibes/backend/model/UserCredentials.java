package com.veggievibes.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserCredentials {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int credentialId;
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;

    @JsonManagedReference
    @OneToOne(mappedBy = "userCredentials", cascade = CascadeType.ALL)
    private UserDetails userDetails;
}