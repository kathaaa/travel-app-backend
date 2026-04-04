package com.travelapp.travel;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Flight {


    //attributes - BOARDING PASS INFORMATION
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String flightNumber;

    //As these fields need the date + time displayed together
    private LocalDateTime boardingTime;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private LocalDate date; //YYYY-MM-DD

    private String origin;
    private String destination;
    private String passengerName;
    private String seat;

    @Column(nullable = true) //these fields change often, live information - 100% up to date
    private String terminal;
    @Column(nullable = true)
    private String gate;
    @Column(nullable = true)
    private Boolean fastTrack;
    @Column(nullable = true)
    private String boardingPassScan;

    @ManyToOne
    private Trip trip;


    public Flight(){}

    public Flight(String flightNumber, LocalDateTime boardingTime, LocalDateTime departureTime, LocalDateTime arrivalTime,
                  LocalDate date, String origin, String destination, String passengerName, String seat, String terminal, String gate,
                  Boolean fastTrack, String boardingPassScan, Trip trip){

        this.flightNumber = flightNumber;
        this.boardingTime = boardingTime;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.passengerName = passengerName;
        this.seat = seat;
        this.terminal = terminal;
        this.gate = gate;
        this.fastTrack = false;
        this.boardingPassScan = boardingPassScan;
        this.trip = trip;
    }

    public Integer getId(){
        return id;
    }

    public String getFlightNumber(){
        return flightNumber;
    }

    public LocalDateTime getBoardingTime(){
        return boardingTime;
    }

    public LocalDateTime getDepartureTime(){
        return departureTime;
    }

    public LocalDateTime getArrivalTime(){
        return arrivalTime;
    }

    public LocalDate getDate(){
        return date;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }

    public String getSeat(){
        return seat;
    }

    public String getPassengerName(){
        return passengerName;
    }

    public String getTerminal(){
        return terminal;
    }

    public String getGate(){
        return gate;
    }

    public String getBoardingPassScan(){
        return boardingPassScan;
    }

    public Boolean getFastTrack(){
        return fastTrack;
    }

    public Trip getTrip(){
        return trip;
    }


    /*setters

    The fields here are fetched live, meaning they can still change during the active booking, the other fields such as
    date, time and destination, flight number etc. won't make sense to change, instead just add a new flight
     */



    public void setFastTrack(Boolean fastTrack){
        this.fastTrack = fastTrack;
    }

    public void setTerminal(String newTerminal){
        this.terminal = newTerminal;
    }

    public void setGate(String newGate){
        this.gate = newGate;

    }

    public void setSeat(String newSeat){this.seat = newSeat;}

    public void setBoardingPassScan(String newBoardingPassScan){
        this.boardingPassScan = newBoardingPassScan;
    }

    public void setTrip(Trip trip){
        this.trip = trip;
    }
}
