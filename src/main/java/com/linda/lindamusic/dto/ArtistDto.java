package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.ArtistStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArtistDto extends BaseDto {
    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private ArtistStatus status;
}