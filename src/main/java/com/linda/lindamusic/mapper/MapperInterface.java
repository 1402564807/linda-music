package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.BaseDto;
import com.linda.lindamusic.entity.BaseEntity;
import org.mapstruct.MappingTarget;

/**
 * 映射器接口
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}