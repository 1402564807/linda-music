package com.linda.lindamusic.service.Impl;

import com.linda.lindamusic.dto.FileDto;
import com.linda.lindamusic.dto.FileUploadDto;
import com.linda.lindamusic.dto.FileUploadRequest;
import com.linda.lindamusic.entity.File;
import com.linda.lindamusic.enums.Storage;
import com.linda.lindamusic.exception.BizException;
import com.linda.lindamusic.mapper.FileMapper;
import com.linda.lindamusic.repository.FileRepository;
import com.linda.lindamusic.service.FileService;
import com.linda.lindamusic.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static com.linda.lindamusic.enums.FileStatus.UPLOADED;
import static com.linda.lindamusic.enums.Storage.COS;
import static com.linda.lindamusic.exception.ExceptionType.FILE_NOT_FOUND;
import static com.linda.lindamusic.exception.ExceptionType.FILE_NOT_PERMISSION;
import static com.linda.lindamusic.utils.FileTypeTransformer.getFileTypeFromExt;

/**
 * 文件服务impl
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Service
public class FileServiceImpl extends BaseService implements FileService {

    private Map<String, StorageService> storageServices;

    private FileRepository repository;

    private FileMapper mapper;

    @Override
    @Transactional
    public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException {
        // 创建File实体
        var file = mapper.createEntity(fileUploadRequest);
        file.setType(getFileTypeFromExt(fileUploadRequest.getExt()));
        file.setStorage(getDefaultStorage());
        file.setCreatedBy(getCurrentUserEntity());
        file.setUpdatedBy(getCurrentUserEntity());
        var savedFile = repository.save(file);
        // 通过接口获取STS令牌
        var fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

        fileUploadDto.setKey(savedFile.getKey());
        fileUploadDto.setFileId(savedFile.getId());
        return fileUploadDto;
    }

    @Override
    public FileDto finishUpload(String id) {
        var file = getFileEntity(id);
        // Todo: 是否是SUPER_ADMIN
        if (!Objects.equals(file.getCreatedBy().getId(), getCurrentUserEntity().getId())) {
            throw new BizException(FILE_NOT_PERMISSION);
        }

        // Todo: 验证远程文件是否存在

        file.setStatus(UPLOADED);
        return mapper.toDto(repository.save(file));
    }

    // Todo: 后台设置当前Storage
    public Storage getDefaultStorage() {
        return COS;
    }

    @Override
    public File getFileEntity(String id) {
        var fileOptional = repository.findById(id);
        if (fileOptional.isEmpty()) {
            throw new BizException(FILE_NOT_FOUND);
        }
        return fileOptional.get();
    }

    @Autowired
    public void setStorageServices(Map<String, StorageService> storageServices) {
        this.storageServices = storageServices;
    }

    @Autowired
    public void setRepository(FileRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(FileMapper mapper) {
        this.mapper = mapper;
    }
}