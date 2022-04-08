package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.FileStatus;
import com.linda.lindamusic.enums.FileType;
import com.linda.lindamusic.enums.Storage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class FileDto extends BaseDto {
    private String name;

    private String key;

    private String uri;

    private String ext;

    private Long size;

    private FileType type;

    private Storage storage;

    private FileStatus status;
}