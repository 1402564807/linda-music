package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.BaseDto;
import com.linda.lindamusic.entity.BaseEntity;
import com.linda.lindamusic.exception.ExceptionType;
import com.linda.lindamusic.mapper.MapperInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {
    JpaRepository<Entity, String> getRepository();

    MapperInterface<Entity, Dto> getMapper();

    ExceptionType getNotFoundExceptionType();

    Dto create(Dto dto);

    Dto get(String id);

    Dto update(String id, Dto dto);

    void delete(String id);

}