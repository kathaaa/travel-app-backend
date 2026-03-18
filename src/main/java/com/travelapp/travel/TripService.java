package com.travelapp.travel;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@Service
public class TripService {

    //attributes
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    public Trip createTrip(Trip trip){
        return tripRepository.save(trip);
    }

    public Optional<Trip> getTripById(Integer id){

        return tripRepository.findById(id);
    }

    public void deleteTrip(Integer id){
        tripRepository.deleteById(id);
    }

    public Trip updateDates(Integer id, LocalDate newStartDate, LocalDate newReturnDate){
        return getTripById(id).map(t -> {t.setStartDate(newStartDate);
            t.setReturnDate(newReturnDate);
            return tripRepository.save(t);

        })
        .orElseThrow(()-> new RuntimeException("Trip not found"));
    }
}

