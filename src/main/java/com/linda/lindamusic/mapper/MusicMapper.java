package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.MusicCreateRequest;
import com.linda.lindamusic.dto.MusicDto;
import com.linda.lindamusic.dto.MusicUpdateRequest;
import com.linda.lindamusic.entity.Music;
import com.linda.lindamusic.vo.MusicVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = FileMapper.class)
public interface MusicMapper extends MapperInterface<Music, MusicDto> {
    MusicDto toDto(MusicCreateRequest musicCreateRequest);

    MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

    MusicVo toVo(MusicDto musicDto);
}