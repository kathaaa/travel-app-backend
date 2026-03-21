package com.travelapp.travel;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Trip{

    //attributes
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String cityName;
    private String countryName;
    private LocalDate startDate;

    @Column(nullable = true)
    private LocalDate returnDate;


    public Trip(){}
    public Trip(String cityName, String countryName, LocalDate startDate, LocalDate returnDate){
        this.cityName = cityName;
        this.countryName = countryName;
        this.startDate = startDate;
        this.returnDate = returnDate;


    }

    //Getters
    public String getCityName(){
        return cityName;
    }

    public String getCountryName(){
        return countryName;
    }

    public Integer getId(){
        return id;
    }

    public LocalDate getStartDate(){return startDate;}

    public LocalDate getReturnDate(){return returnDate;}

    //Setters

    /*
    trip dates as plans can change, easier to change dates for a trip than having to create
    a whole new trip with the exact same details just to give it new dates, its stand alone and are not
    influencing/conflicting other features in the app
     */
    public void setStartDate(LocalDate newStartDate){
        this.startDate = newStartDate;

    }

    public void setReturnDate(LocalDate newReturnDate){
        this.returnDate = newReturnDate;

    }

    /*No setters for city or country as it will create conflict with
     other features that are dependent on the trip destination such as packing list, visual map planning
     and weather for the destination.

    Creating a new trip on a clean slate is much better
     */


}