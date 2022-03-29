package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.FileStatus;
import com.linda.lindamusic.enums.FileType;
import com.linda.lindamusic.enums.Storage;
import lombok.Data;

import java.util.Date;

/**
 * 文件dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class FileDto {
    private String id;

    private String name;

    private String key;

    private String uri;

    private String ext;

    private Long size;

    private FileType type;

    private Storage storage;

    private FileStatus status;

    private Date createdTime;

    private Date updatedTime;
}