package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.model.COLocation;
import com.kts.project.backend.model.User;
import com.kts.project.backend.repository.CulturalOfferRepository;
import com.kts.project.backend.repository.LocationRepository;

@Service
public class CulturalOfferService {

	@Autowired
	CulturalOfferRepository culturalOfferRepo;
	
	@Autowired
	LocationRepository locationsRepo;
	
	
	public List<COLocation> getAllLocations(){
		return locationsRepo.findAll();
	}
	
	public COLocation createLocation(COLocation entity) throws Exception {
		
        return locationsRepo.save(entity);
	}
}
