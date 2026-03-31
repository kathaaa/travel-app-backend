package com.travelapp.travel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkerRepository extends JpaRepository<Marker, Integer> {

    List<Marker> findByTripId(Integer tripId);
}
