package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.ArtistStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 艺术家vo
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArtistVo extends BaseVo {
    private String name;

    private String remark;

    private FileVo photo;

    private List<MusicVo> musicDtoList;

    private ArtistStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}