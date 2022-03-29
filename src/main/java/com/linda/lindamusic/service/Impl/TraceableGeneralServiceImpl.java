package com.linda.lindamusic.service.Impl;

import com.linda.lindamusic.dto.BaseDto;
import com.linda.lindamusic.entity.TraceableBaseEntity;

/**
 * 可追踪一般事务impl
 *
 * @author 林思涵
 * @date 2022/03/29
 */
abstract class TraceableGeneralServiceImpl<Entity extends TraceableBaseEntity, Dto extends BaseDto> extends GeneralServiceImpl<Entity, Dto> {
    @Override
    public Dto create(Dto dto) {
        var entity = getMapper().toEntity(dto);
        entity.setCreatedBy(getCurrentUserEntity());
        entity.setUpdatedBy(getCurrentUserEntity());
        return getMapper().toDto(getRepository().save(entity));
    }

    @Override
    public Dto update(String id, Dto dto) {
        var existedEntity = getEntity(id);
        var entity = getMapper().updateEntity(existedEntity, dto);
        entity.setUpdatedBy(getCurrentUserEntity());
        var updatedEntity = getRepository().save(entity);
        return getMapper().toDto(updatedEntity);
    }
}