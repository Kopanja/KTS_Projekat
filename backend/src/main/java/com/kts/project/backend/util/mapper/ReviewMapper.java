package com.kts.project.backend.util.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.kts.project.backend.dto.ReviewDTO;
import com.kts.project.backend.model.Content;
import com.kts.project.backend.model.CulturalOffer;
import com.kts.project.backend.model.Review;
import com.kts.project.backend.model.User;
import com.kts.project.backend.service.ContentService;
import com.kts.project.backend.service.CulturalOfferService;
import com.kts.project.backend.service.UserService;
import com.kts.project.backend.util.MapperInterface;

public class ReviewMapper implements MapperInterface<Review, ReviewDTO> {

	@Autowired
	UserService userService;
	
	@Autowired
	CulturalOfferService coService;
	
	@Autowired
	ContentService contentService;
	
	@Override
	public Review toEntity(ReviewDTO dto) {
		User user = userService.findOne(dto.getUserId());
		CulturalOffer coOffer = coService.findById(dto.getCoId());
		Content content = contentService.findById(dto.getContentId());
		return new Review(null,0,content,user,coOffer);
	}
	@Override
	public ReviewDTO toDto(Review entity) {
		return new ReviewDTO(entity.getRating(), entity.getContent().getId(), entity.getUser().getId(), entity.getCulturalOffer().getId());
	}

}
