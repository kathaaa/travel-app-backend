package com.travelapp.travel;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String profilePhoto;
    private String password; //encrypted version later

    @OneToMany(mappedBy = "user")
    private final List<Trip> trips = new ArrayList<>();

    public User(){}

    public User(String name, String email, String password, String profilePhoto){
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getProfilePhoto(){
        return profilePhoto;
    }

    public List<Trip> getTrips(){
        return trips;
    }

    public Integer getId(){
        return id;
    }

    //setters, all attributes besides id and trips, trips gets added when user creates a trip, list is automatically managed

    public void setName(String newName){
        this.name = newName;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public void setProfilePhoto(String newProfilePhoto){
        this.profilePhoto = newProfilePhoto;
    }
}

