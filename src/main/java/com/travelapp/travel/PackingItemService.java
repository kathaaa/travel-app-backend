package com.travelapp.travel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackingItemService {

    //attributes
    private final PackingItemRepository packingItemRepository;

    public PackingItemService(PackingItemRepository packingItemRepository){
        this.packingItemRepository = packingItemRepository;
    }


    public List<PackingItem> getPackingItemsByTripId(Integer tripId){
        return packingItemRepository.findByTripId(tripId);
    }

    public PackingItem createPackingItem(PackingItem item){
        return packingItemRepository.save(item);
    }

    public void deletePackingItem(Integer id){
        packingItemRepository.deleteById(id);
    }

    public PackingItem updatePackingItem(Integer id, Boolean newChecked, String newName){
        return packingItemRepository.findById(id).map(i -> {
            if(newName != null) i.setName(newName);
            if(newChecked != null) i.setChecked(newChecked);
            return packingItemRepository.save(i);

        })
                .orElseThrow(()-> new RuntimeException("Packing item not found"));
    }





}
