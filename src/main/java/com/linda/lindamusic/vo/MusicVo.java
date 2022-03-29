package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.MusicStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 音乐vo
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Getter
@Setter
@ToString
public class MusicVo extends BaseVo {

    private String name;

    private MusicStatus status;

    private String description;

    private FileVo file;

    private List<ArtistVo> artistList;
}