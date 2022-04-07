package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.PlayListStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 播放列表dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PlaylistDto extends TraceableBaseDto {

    private String name;

    private String description;

    private FileDto cover;

    private PlayListStatus status;

    private List<MusicDto> musicList;

    private Boolean recommended;

    private Integer recommendFactor;

    private Boolean special;
}