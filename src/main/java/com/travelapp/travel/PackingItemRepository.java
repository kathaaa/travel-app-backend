package com.travelapp.travel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackingItemRepository extends JpaRepository<PackingItem, Integer> {


    List<PackingItem> findByTripId(Integer tripId);
    //spring writes the SQL automatically
}
