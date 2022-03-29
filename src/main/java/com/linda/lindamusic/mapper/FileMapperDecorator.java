package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.FileDto;
import com.linda.lindamusic.entity.File;
import com.linda.lindamusic.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * 文件映射装饰器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public abstract class FileMapperDecorator implements FileMapper {

    @Qualifier("delegate")
    private FileMapper delegate;

    private Map<String, StorageService> storageServices;

    @Override
    public FileDto toDto(File file) {
        FileDto fileDto = delegate.toDto(file);

        if (fileDto == null) {
            return null;
        }

        if (fileDto.getStorage() == null) {
            return null;
        }

        fileDto.setUri(storageServices.get(fileDto.getStorage().name()).getFileUri(fileDto.getKey()));
        return fileDto;
    }

    @Autowired
    public void setDelegate(FileMapper delegate) {
        this.delegate = delegate;
    }

    @Autowired
    public void setStorageServices(Map<String, StorageService> storageServices) {
        this.storageServices = storageServices;
    }
}