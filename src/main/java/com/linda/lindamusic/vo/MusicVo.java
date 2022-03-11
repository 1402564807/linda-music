package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.MusicStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MusicVo extends BaseVo {

    private String name;

    private MusicStatus status;

    private String description;

    private FileVo file;
}