package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.FileUploadDto;
import com.linda.lindamusic.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}