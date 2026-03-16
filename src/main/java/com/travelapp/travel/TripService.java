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

    public void updateDates(LocalDate newStartDate, LocalDate newReturnDate, Integer id){
        getTripById(id).ifPresent(t -> {t.setStartDate(newStartDate);
            t.setReturnDate(newReturnDate);
            tripRepository.save(t);

        });
    }
}

