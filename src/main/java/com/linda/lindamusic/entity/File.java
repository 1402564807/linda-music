package com.linda.lindamusic.entity;

import com.linda.lindamusic.enums.FileStatus;
import com.linda.lindamusic.enums.FileType;
import com.linda.lindamusic.enums.Storage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 文件
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Entity
@Getter
@Setter
@ToString
public class File extends TraceableBaseEntity {
    private String name;

    @Column(name = "file_key")
    private String key;

    private String ext;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private Storage storage;

    @Enumerated(EnumType.STRING)
    private FileStatus status = FileStatus.UPLOADING;
}