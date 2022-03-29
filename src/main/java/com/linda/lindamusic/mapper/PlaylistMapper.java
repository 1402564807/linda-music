package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.PlaylistDto;
import com.linda.lindamusic.entity.Playlist;
import com.linda.lindamusic.vo.PlaylistVo;
import org.mapstruct.Mapper;

/**
 * 播放列表映射器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Mapper(componentModel = "spring", uses = MusicMapper.class)
public interface PlaylistMapper {
    PlaylistDto toDto(Playlist playlist);

    PlaylistVo toVo(PlaylistDto playlistDto);
}