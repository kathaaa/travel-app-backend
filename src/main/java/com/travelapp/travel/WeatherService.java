package com.travelapp.travel;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    //API

    @Value("${weather.api.key}") //Api key value connected to the application properties
    private String apiKey;

    private final RestClient restClient = RestClient.create();


    public String getWeather(String city){
        System.out.println("API KEY: " + apiKey); // remove later, just for test
        return restClient.get()
                .uri("https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric", apiKey, city)
                .retrieve()
                .body(String.class);
        //returns response as a string
    }








}
