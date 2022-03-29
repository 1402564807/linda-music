package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.MusicStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;


/**
 * 音乐dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MusicDto extends BaseDto {
    private String name;

    private MusicStatus status = MusicStatus.DRAFT;

    private String description;

    private FileDto file;

    private List<ArtistDto> artistList;
}