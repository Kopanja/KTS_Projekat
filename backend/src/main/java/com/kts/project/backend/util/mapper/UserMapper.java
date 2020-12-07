package com.kts.project.backend.util.mapper;

import com.kts.project.backend.dto.UserDTO;
import com.kts.project.backend.model.User;
import com.kts.project.backend.util.MapperInterface;

public class UserMapper implements MapperInterface<User, UserDTO> {

	@Override
	public User toEntity(UserDTO dto) {
		return new User(dto.getId(),dto.getEmail());	
		}

	@Override
	public UserDTO toDto(User entity) {
		return new UserDTO(entity.getId(),entity.getEmail());
	}

}
