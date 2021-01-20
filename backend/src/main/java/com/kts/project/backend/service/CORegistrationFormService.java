package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.dto.CulturalOfferDTO;
import com.kts.project.backend.model.CORegistrationForm;
import com.kts.project.backend.model.User;
import com.kts.project.backend.repository.CORegistrationRepository;

@Service
public class CORegistrationFormService {

	@Autowired
	CORegistrationRepository coRegistrationRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CulturalOfferService culturalOfferService;
	
	@Autowired
	UserAuthorityService userAuthService;
	
	public List<CORegistrationForm> getAll(){
		
		return coRegistrationRepo.findAll();
		
	}
	
	public CORegistrationForm findById(Long id) {
		return coRegistrationRepo.findById(id).orElse(null);
	}
	
	public CORegistrationForm findByName(String name) {
		return coRegistrationRepo.findByName(name);
	}
	
	public CORegistrationForm create(CORegistrationForm newForm) {
		return coRegistrationRepo.save(newForm);
	}
	
	public void delete(Long id) throws Exception {
		CORegistrationForm existingApplication = coRegistrationRepo.findById(id).orElse(null);
        if(existingApplication == null){
            throw new Exception("User given id doesn't exist");
        }
        coRegistrationRepo.delete(existingApplication);
        
	}
	
	public CulturalOfferDTO approveRegistrationForm(Long id) throws Exception {
		//Validacija i automatsko generisanje sifre
		CORegistrationForm registrationForm = this.findById(id);	
		User admin = new User();
		admin.setEmail(registrationForm.getEmail());
		admin.setPassword("123");
		admin = userService.create(admin);
		userAuthService.create(admin.getId(), "ROLE_ADMIN");
		CulturalOfferDTO culturalOffer = culturalOfferService.createCulturalOfferFromApplication(registrationForm, admin);
		return culturalOffer;
	}

	
	
}
