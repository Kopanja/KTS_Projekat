package com.kts.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.project.backend.model.COLocation;
import com.kts.project.backend.service.CulturalOfferService;


@RestController
@RequestMapping(value="api/cultural-offer")
public class CulturalOfferController {
	@Autowired
	CulturalOfferService coService;

	
	@RequestMapping(value= "/locations",method = RequestMethod.GET)
    public ResponseEntity<List<COLocation>> getAllUsers() {
        
		List<COLocation> allLocations = coService.getAllLocations();
        return new ResponseEntity<>(allLocations, HttpStatus.OK);
    }
	@RequestMapping(value= "/locations",method = RequestMethod.POST)
	public ResponseEntity<COLocation> createNewLocation(@RequestBody COLocation locationDTO){
        
		COLocation location;
        try {
        	locationDTO.setId(null);
            location = coService.createLocation(locationDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }
}
