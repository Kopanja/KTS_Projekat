package com.kts.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.project.backend.dto.CulturalOfferDTO;
import com.kts.project.backend.model.COLocation;
import com.kts.project.backend.model.CulturalOffer;
import com.kts.project.backend.service.CulturalOfferService;


@RestController
@RequestMapping(value="api/cultural-offer")
public class CulturalOfferController {
	@Autowired
	CulturalOfferService coService;

	
	@RequestMapping(value= "/locations",method = RequestMethod.GET)
    public ResponseEntity<List<COLocation>> getAllLocations() {
        
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
	

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CulturalOfferDTO>> getAllCulturalOffer() {
        
		List<CulturalOfferDTO> allCulturalOffer = coService.getAllCulturalOffers();
        return new ResponseEntity<>(allCulturalOffer, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CulturalOfferDTO> createNewCulturalOffer(@RequestBody CulturalOfferDTO culturalOfferDTO){
        
		CulturalOfferDTO culturalOffer;
        try {
        	culturalOffer = coService.createCulturalOffer(culturalOfferDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(culturalOffer, HttpStatus.CREATED);
    }
	
	@RequestMapping(value= "/{id}/add-location",method = RequestMethod.POST)
	public ResponseEntity<CulturalOfferDTO> setLocation(@PathVariable Long id, @RequestBody COLocation locationDTO){
        
		CulturalOfferDTO culturalOffer = null;
		try {
			culturalOffer = coService.setLocation(id, locationDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

        return new ResponseEntity<>(culturalOffer, HttpStatus.CREATED);
    }
}
