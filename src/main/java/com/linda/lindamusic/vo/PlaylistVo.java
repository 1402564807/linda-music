package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.PlayListStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class PlaylistVo extends BaseVo {
    private String id;

    private String name;

    private String description;

    private FileVo cover;

    private PlayListStatus status;

    private UserVo creator;

    private List<MusicVo> musicList;

    private Date createdTime;

    private Date updatedTime;
}