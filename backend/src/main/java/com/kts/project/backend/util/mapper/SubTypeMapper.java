package com.kts.project.backend.util.mapper;

import com.kts.project.backend.dto.SubTypeDTO;
import com.kts.project.backend.dto.TypeDTO;
import com.kts.project.backend.model.SubType;
import com.kts.project.backend.model.Type;
import com.kts.project.backend.util.MapperInterface;

public class SubTypeMapper implements MapperInterface<SubType, SubTypeDTO> {

	@Override
	public SubType toEntity(SubTypeDTO dto) {
		Type parentType = new Type(dto.getParentType().getId(), dto.getParentType().getName());
		return new SubType(dto.getId(),dto.getName(),parentType);
	}

	@Override
	public SubTypeDTO toDto(SubType entity) {
		TypeDTO parentTypeDto = new TypeDTO(entity.getType().getId(), entity.getType().getName());
		return new SubTypeDTO(entity.getId(),entity.getName(),parentTypeDto);
	}

}
