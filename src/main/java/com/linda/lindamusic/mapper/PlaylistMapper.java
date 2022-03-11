package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.PlaylistDto;
import com.linda.lindamusic.entity.Playlist;
import com.linda.lindamusic.vo.PlaylistVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MusicMapper.class)
public interface PlaylistMapper {
    PlaylistDto toDto(Playlist playlist);

    PlaylistVo toVo(PlaylistDto playlistDto);
}