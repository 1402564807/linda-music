package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.FileDto;
import com.linda.lindamusic.dto.FileUploadDto;
import com.linda.lindamusic.dto.FileUploadRequest;
import com.linda.lindamusic.entity.File;
import com.linda.lindamusic.enums.Storage;

import java.io.IOException;

/**
 * 文件服务
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();

    File getFileEntity(String id);
}
