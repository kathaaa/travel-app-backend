package com.travelapp.travel;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    //endpoints: GET /trips, GET /trips{id}, POST /trips, DELETE/trips{id}, PUT /trips{id}


    private final TripService tripService;


    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public List<Trip> getTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable Integer id){

        return tripService.getTripById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/trips")
    public Trip createTrip(@RequestBody Trip trip){ //gets the json body from the request
        return tripService.createTrip(trip);
    }


    @DeleteMapping("/trips/{id}")
    public ResponseEntity<Void> removeTrip(@PathVariable Integer id){
        //returns an http status code but no body (no content) as it deletes, it will then return "204 no content"
        tripService.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> updateDates(@PathVariable Integer id, @RequestBody UpdateDatesRequest request){

        return ResponseEntity.ok(tripService.updateDates(id, request.getStartDate(), request.getReturnDate()));
    }


}

