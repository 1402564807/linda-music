package com.linda.lindamusic.service.Impl;

import com.linda.lindamusic.dto.BaseDto;
import com.linda.lindamusic.entity.BaseEntity;
import com.linda.lindamusic.exception.BizException;
import com.linda.lindamusic.service.GeneralService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 一般事务人员
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public abstract class GeneralServiceImpl<Entity extends BaseEntity, Dto extends BaseDto> extends BaseService implements GeneralService<Entity, Dto> {

    @Override
    public Dto create(Dto dto) {
        var entity = getMapper().toEntity(dto);
        return getMapper().toDto(getRepository().save(entity));
    }

    @Override
    public Dto get(String id) {
        return getMapper().toDto(getEntity(id));
    }

    protected Entity getEntity(String id) {
        var optionalEntity = getRepository().findById(id);
        if (optionalEntity.isEmpty()) {
            throw new BizException(getNotFoundExceptionType());
        }
        return optionalEntity.get();
    }


    @Override
    @Transactional
    public Dto update(String id, Dto dto) {
        // Todo: dto 可能无法控制更新字段
        var existedEntity = getEntity(id);
        var updatedEntity = getRepository().save(getMapper().updateEntity(existedEntity, dto));
        return getMapper().toDto(updatedEntity);
    }

    @Override
    public void delete(String id) {
        var existedEntity = getEntity(id);
        getRepository().delete(existedEntity);
    }
}