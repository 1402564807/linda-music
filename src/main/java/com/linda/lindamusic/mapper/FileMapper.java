package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.FileDto;
import com.linda.lindamusic.dto.FileUploadRequest;
import com.linda.lindamusic.entity.File;
import com.linda.lindamusic.vo.FileVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);

    File toEntity(FileDto fileDto);
}