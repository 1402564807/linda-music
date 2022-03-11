package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.BaseDto;
import com.linda.lindamusic.entity.BaseEntity;
import org.mapstruct.MappingTarget;

public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}