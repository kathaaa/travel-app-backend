package com.travelapp.travel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CurrencyService {

// CURRENCY API

    @Value("${currency.api.key}")
    private String apiKey; //always create a string for the implemented value annotation

    private final RestClient restClient = RestClient.create();

    public String getCurrency(String currency){
        return restClient.get().uri("https://v6.exchangerate-api.com/v6/{apiKey}/latest/{baseCurrency}", apiKey, currency)
                .retrieve()
                .body(String.class);
    }
    //returns a string response
    //use the API endpoint url in the uri brackets, not the website url
}
