package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.FileUploadDto;

import java.io.IOException;

/**
 * 存储服务
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface StorageService {
    FileUploadDto initFileUpload() throws IOException;

    String getFileUri(String fileKey);
}