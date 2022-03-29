package com.linda.lindamusic.mapper;


import com.linda.lindamusic.dto.ArtistCreateRequest;
import com.linda.lindamusic.dto.ArtistDto;
import com.linda.lindamusic.dto.ArtistUpdateRequest;
import com.linda.lindamusic.entity.Artist;
import com.linda.lindamusic.vo.ArtistVo;
import org.mapstruct.Mapper;

/**
 * 艺术家绘图员
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class})
public interface ArtistMapper extends MapperInterface<Artist, ArtistDto> {
    ArtistDto toDto(ArtistCreateRequest artistCreateRequest);

    ArtistDto toDto(ArtistUpdateRequest artistUpdateRequest);

    ArtistVo toVo(ArtistDto artistDto);
}
