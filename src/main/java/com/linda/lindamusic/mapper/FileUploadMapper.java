package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.FileUploadDto;
import com.linda.lindamusic.vo.FileUploadVo;
import org.mapstruct.Mapper;

/**
 * 文件上传映射器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}