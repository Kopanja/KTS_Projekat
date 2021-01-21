package com.kts.project.backend.util.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.kts.project.backend.dto.ContentDTO;
import com.kts.project.backend.model.Content;
import com.kts.project.backend.model.CulturalOffer;
import com.kts.project.backend.model.Subscription;
import com.kts.project.backend.model.User;
import com.kts.project.backend.service.UserService;
import com.kts.project.backend.util.MapperInterface;

public class ContentMapper implements MapperInterface<Content, ContentDTO> {

	@Autowired
	UserService userService;
	@Override
	public Content toEntity(ContentDTO dto) {
		User user = userService.findOne(dto.getUserId());
		return new Content(null,dto.getText(),null, user);
	}

	@Override
	public ContentDTO toDto(Content entity) {
		return new ContentDTO(entity.getText(), entity.getUser().getId());
	}

}
