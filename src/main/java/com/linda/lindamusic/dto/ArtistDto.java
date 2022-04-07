package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.ArtistStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 艺术家dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArtistDto extends TraceableBaseDto {
    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private ArtistStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}