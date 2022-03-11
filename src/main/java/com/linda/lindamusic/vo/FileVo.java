package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.FileStatus;
import com.linda.lindamusic.enums.FileType;
import com.linda.lindamusic.enums.Storage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileVo extends BaseVo {
    private String name;

    private String key;

    private String uri;

    private Storage storage;

    private String ext;

    private Long size;

    private FileType type;

    private FileStatus status;
}