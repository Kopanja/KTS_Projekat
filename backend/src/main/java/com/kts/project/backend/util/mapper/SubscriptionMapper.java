package com.kts.project.backend.util.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.kts.project.backend.dto.SubscriptionDTO;
import com.kts.project.backend.model.CulturalOffer;
import com.kts.project.backend.model.Subscription;
import com.kts.project.backend.model.User;
import com.kts.project.backend.service.CulturalOfferService;
import com.kts.project.backend.service.UserService;
import com.kts.project.backend.util.MapperInterface;

public class SubscriptionMapper implements MapperInterface<Subscription, SubscriptionDTO> {

	@Autowired
	UserService userService;
	
	@Autowired
	CulturalOfferService coService;
	@Override
	public Subscription toEntity(SubscriptionDTO dto) {
		User sub = userService.findOne(dto.getSubscriberId());
		CulturalOffer pub = coService.findById(dto.getPublisherId());
		return new Subscription(null,sub,pub);
	}

	@Override
	public SubscriptionDTO toDto(Subscription entity) {
		return new SubscriptionDTO(entity.getUser().getId(), entity.getCulturalOffer().getId());
	}

}
