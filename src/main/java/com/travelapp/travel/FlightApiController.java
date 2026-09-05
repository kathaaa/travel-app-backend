package com.travelapp.travel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FlightApiController {

    //API CONTROLLER


    private final FlightApiService flightApiService;

    public FlightApiController(FlightApiService flightApiService){
        this.flightApiService = flightApiService;
    }

    @GetMapping("/flight/live")
    public String getFlightData(@RequestParam String flightNumber){
        return flightApiService.getFlightData(flightNumber);
    }
}
