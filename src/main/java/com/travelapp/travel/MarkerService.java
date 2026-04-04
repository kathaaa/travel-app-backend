package com.travelapp.travel;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkerService {

    private final MarkerRepository markerRepository;



    public MarkerService(MarkerRepository markerRepository){
        this.markerRepository = markerRepository;
    }

    public List<Marker> getMarkersByTripId(Integer tripId){
        return markerRepository.findByTripId(tripId);
    }
    //as markers are special to each trip, all markers would be too broad, so instead getting markers by a certain trip

    public Marker createMarker(Marker marker){
        return markerRepository.save(marker);
    }

    public Marker getMarkerById(Integer id){
        return markerRepository.findById(id).orElseThrow(()-> new RuntimeException("Marker not found"));
    }

    public void deleteMarker(Integer id){
        markerRepository.deleteById(id);
    }

    public Marker updateMarker(Integer id, String newName, String newNotes,
                               String newHotelInfo, String newTransportation){
        return markerRepository.findById(id).map(m -> {
            if(newName != null) m.setName(newName);
            if(newNotes != null) m.setNotes(newNotes);
            if(newHotelInfo != null) m.setHotelInfo(newHotelInfo);
            if(newTransportation != null) m.setTransportation(newTransportation);
            return markerRepository.save(m);
        })
                .orElseThrow(()-> new RuntimeException("Marker not found"));
    }


}
