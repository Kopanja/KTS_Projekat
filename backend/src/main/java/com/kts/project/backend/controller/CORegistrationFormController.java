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
import com.kts.project.backend.model.CORegistrationForm;
import com.kts.project.backend.service.CORegistrationFormService;

@RestController
@RequestMapping(value="api/application-forms")
public class CORegistrationFormController {
	
	@Autowired
	CORegistrationFormService coRegistrationService;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CORegistrationForm>> getAllCORegistrationForm() {
        
		List<CORegistrationForm> allCulturalOffer = coRegistrationService.getAll();
        return new ResponseEntity<>(allCulturalOffer, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<CORegistrationForm> getCORegistrationFormById(@PathVariable Long id) {
        
		CORegistrationForm registrationForm = coRegistrationService.findById(id);
        if(registrationForm == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(registrationForm, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}/accept",method = RequestMethod.GET)
    public ResponseEntity<CulturalOfferDTO> approveCORegistrationForm(@PathVariable Long id) {
        
		CulturalOfferDTO newCulturalOffer = null;
		try {
			newCulturalOffer = coRegistrationService.approveRegistrationForm(id);
			coRegistrationService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(newCulturalOffer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newCulturalOffer, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}/reject",method = RequestMethod.DELETE)
    public ResponseEntity<CORegistrationForm> rejectCORegistrationForm(@PathVariable Long id) {
		
		try {
			coRegistrationService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CORegistrationForm> createNewCORegistrationForm(@RequestBody CORegistrationForm coRegistrationForm){
        
		CORegistrationForm newCORegistrationForm;
        try {
        	newCORegistrationForm = coRegistrationService.create(coRegistrationForm);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(newCORegistrationForm, HttpStatus.CREATED);
    }

}
