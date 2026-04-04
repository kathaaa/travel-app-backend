package com.travelapp.travel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {


    private final FlightRepository flightRepository;


    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlightByTripId(Integer tripId){
        return flightRepository.findByTripId(tripId);
    }

    public Flight createFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public Flight getFlightById(Integer id){
        return flightRepository.findById(id).orElseThrow(()-> new RuntimeException("Flight not found"));
    }

    public void deleteFlight(Integer id){
        flightRepository.deleteById(id);
    }

    public Flight updateFlight(Integer id, Boolean fastTrack, String newTerminal,
                               String newGate, String newBoardingPassScan, String newSeat){
        return flightRepository.findById(id).map(f -> {
            if(fastTrack != null) f.setFastTrack(fastTrack);
            if(newTerminal != null) f.setTerminal(newTerminal);
            if(newGate != null) f.setGate(newGate);
            if(newBoardingPassScan != null) f.setBoardingPassScan(newBoardingPassScan);
            if(newSeat != null) f.setSeat(newSeat);
            return flightRepository.save(f);
        })
                .orElseThrow(()-> new RuntimeException("flight not found"));

    }


}
