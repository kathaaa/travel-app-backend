package com.travelapp.travel;



import jakarta.persistence.*;

@Entity
public class Marker {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Trip trip;

    //as coordinates are latitude and longitude, not just coordinates
    private double longitude;
    private double latitude;

    private String notes;

    @Column(nullable = true)
    private String name; //as marker name is optional
    private String hotelInfo; //for now just manually, later hotel integration feature
    private String transportation;

    public Marker(){}

    public Marker(double longitude, double latitude, String name, String notes,
                  String hotelInfo, String transportation, Trip trip){
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.notes = notes;
        this.hotelInfo = hotelInfo;
        this.transportation = transportation;
        this.trip = trip;

    }

    public double getLongitude(){
        return longitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public String getName(){
        return name;
    }

    public String getNotes(){
        return notes;
    }

    public String getHotelInfo(){
        return hotelInfo;
    }

    public String getTransportation(){
        return transportation;
    }

    public Integer getId(){
        return id;
    }

    public Trip getTrip(){
        return trip;
    }

    //setters
    public void setName(String newName){
        this.name = newName;
    }

    public void setNotes(String newNotes){
        this.notes = newNotes;
    }

    public void setHotelInfo(String newHotelInfo){
        this.hotelInfo = newHotelInfo;
    }

    public void setTransportation(String newTransportation){
        this.transportation = newTransportation;
    }

    //no setters for the coordinates as if the location changes the marker will be in the wrong place

    public void setTrip(Trip trip){
        this.trip = trip;
    }



}
