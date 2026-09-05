package com.travelapp.travel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClient;

public class FlightApiService {


    //FLIGHT API,
    // important to separate the names from similar files with similar names, that's why api

    @Value("28bd132e47f65ddda11941999fbbe871")
    private String apiKey;

    private final RestClient restClient = RestClient.create();


    public String getFlightData(String flightNumber){
        return restClient.get().uri("https://api.aviationstack.com/v1/flights?access_key={apiKey}&flight_iata={flightNumber}", apiKey, flightNumber)
                .retrieve()
                .body(String.class);
    }
}
