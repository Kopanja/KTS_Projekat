package com.kts.project.backend.util;

public interface MapperInterface<Entity,Dto> {

	Entity toEntity(Dto dto);

    Dto toDto(Entity entity);
}
