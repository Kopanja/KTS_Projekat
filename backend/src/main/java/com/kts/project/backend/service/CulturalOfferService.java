package com.kts.project.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.dto.CulturalOfferDTO;
import com.kts.project.backend.model.COLocation;
import com.kts.project.backend.model.CORegistrationForm;
import com.kts.project.backend.model.CulturalOffer;
import com.kts.project.backend.model.User;
import com.kts.project.backend.repository.CulturalOfferRepository;
import com.kts.project.backend.repository.LocationRepository;
import com.kts.project.backend.util.mapper.CulturalOfferMapper;

@Service
public class CulturalOfferService {

	@Autowired
	CulturalOfferRepository culturalOfferRepo;
	
	@Autowired
	LocationRepository locationsRepo;
	
	@Autowired
	SubTypeService subTypeService;

	
	CulturalOfferMapper mapper = new CulturalOfferMapper();
	
	public List<COLocation> getAllLocations(){
		return locationsRepo.findAll();
	}
	
	public COLocation createLocation(COLocation entity) throws Exception {
        return locationsRepo.save(entity);
	}
	
	public List<CulturalOfferDTO> getAllCulturalOffers(){
		List<CulturalOfferDTO> dtos = new ArrayList<CulturalOfferDTO>();
		for(CulturalOffer co : culturalOfferRepo.findAll()) {
			dtos.add(mapper.toDto(co));
		}
		return dtos;
	}
	
	public CulturalOfferDTO createCulturalOffer(CulturalOffer entity) {
		return mapper.toDto(culturalOfferRepo.save(entity));
	}
	
	public CulturalOfferDTO createCulturalOffer(CulturalOfferDTO entity) {
		CulturalOffer culturalOffer = mapper.toEntity(entity);
		culturalOffer.setSubType(subTypeService.findByName(entity.getSubType()));
		return mapper.toDto(culturalOfferRepo.save(culturalOffer));
	}
	
	public CulturalOfferDTO setLocation(Long id, COLocation locationDTO) throws Exception {
		CulturalOffer existingCO = culturalOfferRepo.findById(id).orElse(null);
		COLocation location = this.createLocation(locationDTO);
		existingCO.setLocation(location);
		return mapper.toDto(culturalOfferRepo.save(existingCO));
	}
	
	public CulturalOfferDTO createCulturalOfferFromApplication(CORegistrationForm form, User admin) {
		CulturalOffer culturalOffer = new CulturalOffer();
		culturalOffer.setAdmin(admin);
		culturalOffer.setName(form.getName());
		culturalOffer.setSubType(subTypeService.findByName(form.getSubType()));
		return mapper.toDto(culturalOfferRepo.save(culturalOffer));
	}
	
	
}
