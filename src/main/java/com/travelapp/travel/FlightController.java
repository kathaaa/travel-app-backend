package com.travelapp.travel;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {


    private final FlightService flightService;
    private final TripService tripService;


    public FlightController(FlightService flightService, TripService tripService){
        this.flightService = flightService;
        this.tripService = tripService;
    }

    @GetMapping("/trips/{tripId}/flights")
    public List<Flight> getFlights(@PathVariable Integer tripId){
        return flightService.getFlightByTripId(tripId);
    }

    @PostMapping("/trips/{tripId}/flights")
    public Flight createFlight(@PathVariable Integer tripId, @RequestBody Flight flight){
        Trip trip = tripService.getTripById(tripId).orElseThrow(()-> new RuntimeException("Trip not found"));
        flight.setTrip(trip);
        return flightService.createFlight(flight);
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Void> removeFlight(@PathVariable Integer id){
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer id, @RequestBody Flight flight){
        return ResponseEntity.ok(flightService.updateFlight(id, flight.getFastTrack(), flight.getTerminal(),
                flight.getGate(), flight.getBoardingPassScan(), flight.getSeat()));
    }
}
