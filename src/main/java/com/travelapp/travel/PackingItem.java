package com.travelapp.travel;


import jakarta.persistence.*;

@Entity
public class PackingItem {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Trip trip;

    private String name;
    private Boolean checked = false;


    public PackingItem(){}
    public PackingItem(String name, Trip trip){
        this.name = name;
        this.trip = trip;
    }

    public String getName(){
        return name;
    }

    public Trip getTrip(){
        return trip;
    }

    public Integer getId(){
        return id;
    }


    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean newChecked) {
        this.checked = newChecked;
    }
    //to set it as checked when the user marks it complete

    public void setName(String newName){
        this.name = newName;
    }
    //in case the user makes a spelling mistake or wants to rename a packing item


    public void setTrip(Trip newTrip){
        this.trip = newTrip;
    }
    //user needs to assign the packing items to a trip and being able to set it to another trip

}
