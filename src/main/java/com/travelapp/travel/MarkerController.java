package com.travelapp.travel;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarkerController {


    private final MarkerService markerService;
    private final TripService tripService;
    public MarkerController(MarkerService markerService, TripService tripService){
        this.markerService = markerService;
        this.tripService = tripService;

    }

    @GetMapping("/trips/{tripId}/markers")
    public List<Marker> getMarkers(@PathVariable Integer tripId){
        return markerService.getMarkersByTripId(tripId);
    }


    @PostMapping("/trips/{tripId}/markers")
    public Marker createMarker(@PathVariable Integer tripId, @RequestBody Marker marker){
        Trip trip = tripService.getTripById(tripId).orElseThrow(()-> new RuntimeException("Trip not found"));
        marker.setTrip(trip);
        return markerService.createMarker(marker);
    }


    @DeleteMapping("/markers/{id}")
    public ResponseEntity<Void> removeMarker(@PathVariable Integer id){

        markerService.deleteMarker(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/markers/{id}")
    public ResponseEntity<Marker> updateMarker(@PathVariable Integer id, @RequestBody Marker marker){
        return ResponseEntity.ok(markerService.updateMarker(id, marker.getName(), marker.getNotes(),
                marker.getHotelInfo(), marker.getTransportation()));
    }

}
