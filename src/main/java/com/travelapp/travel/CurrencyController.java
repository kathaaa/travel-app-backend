package com.travelapp.travel;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {


    //API CONTROLLER


    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }


    @GetMapping("/currency")
    public String getCurrency(@RequestParam String currency){
        return currencyService.getCurrency(currency);
    }


}
