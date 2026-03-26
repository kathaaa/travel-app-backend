package com.travelapp.travel;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PackingItemController {


    private final PackingItemService packingItemService;
    private final TripService tripService;


    public PackingItemController(PackingItemService packingItemService, TripService tripService){
        this.packingItemService = packingItemService;
        this.tripService = tripService;
    }


    @GetMapping("/trips/{tripId}/packingitems")
    public List<PackingItem> getPackingItems(@PathVariable Integer tripId){
        return packingItemService.getPackingItemsByTripId(tripId);
    }

    @PostMapping("/trips/{tripId}/packingitems")
    public PackingItem createPackingItem(@PathVariable Integer tripId, @RequestBody PackingItem item){
        Trip trip = tripService.getTripById(tripId).orElseThrow(()-> new RuntimeException("Trip not found"));
        item.setTrip(trip);
        return packingItemService.createPackingItem(item);
        //when creating a packingitem it needs to be linked to a trip, so we fetch the trip from tripService
    }

    @DeleteMapping("/packingitems/{id}")
    public ResponseEntity<Void> removePackingItem(@PathVariable Integer id){
        packingItemService.deletePackingItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/packingitems/{id}")
    public ResponseEntity<PackingItem> updatePackingItem(@PathVariable Integer id, @RequestBody PackingItem request){

        return ResponseEntity.ok(packingItemService.updatePackingItem(id, request.getChecked(), request.getName()));
    }





}
