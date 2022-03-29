package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.PlayListStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 播放列表dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class PlaylistDto {
    private String id;

    private String name;

    private String description;

    private FileDto cover;

    private PlayListStatus status;

    private UserDto creator;

    private List<MusicDto> musicList;

    private Date createdTime;

    private Date updatedTime;
}