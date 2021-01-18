package com.kts.project.backend.util.mapper;


import com.kts.project.backend.dto.CulturalOfferDTO;
import com.kts.project.backend.model.CulturalOffer;
import com.kts.project.backend.util.MapperInterface;

public class CulturalOfferMapper implements MapperInterface<CulturalOffer, CulturalOfferDTO> {

	
	@Override
	public CulturalOffer toEntity(CulturalOfferDTO dto) {
		CulturalOffer co = new CulturalOffer();
		co.setName(dto.getName());
		co.setDescription(dto.getDescription());
		return co;
	}

	@Override
	public CulturalOfferDTO toDto(CulturalOffer entity) {
		return new CulturalOfferDTO(entity.getName(), entity.getSubType().getName(), entity.getDescription());
	}

}
