package com.kts.project.backend.util.mapper;


import com.kts.project.backend.dto.TypeDTO;
import com.kts.project.backend.model.Type;
import com.kts.project.backend.util.MapperInterface;

public class TypeMapper implements MapperInterface<Type, TypeDTO> {

	@Override
	public Type toEntity(TypeDTO dto) {
		return new Type(dto.getId(),dto.getName());
	}

	@Override
	public TypeDTO toDto(Type entity) {
		return new TypeDTO(entity.getId(),entity.getName());
	}

	



}
