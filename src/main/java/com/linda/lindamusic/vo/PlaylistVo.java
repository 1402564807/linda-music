package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.PlayListStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 播放列表vo
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Getter
@Setter
@ToString
public class PlaylistVo extends BaseVo {
    private String name;

    private String description;

    private FileVo cover;

    private PlayListStatus status;

    private UserVo creator;

    private List<MusicVo> musicList;
}