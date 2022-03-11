package com.linda.lindamusic.mapper;


import com.linda.lindamusic.dto.ArtistCreateRequest;
import com.linda.lindamusic.dto.ArtistDto;
import com.linda.lindamusic.dto.ArtistUpdateRequest;
import com.linda.lindamusic.entity.Artist;
import com.linda.lindamusic.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class})
public interface ArtistMapper {

    Artist createEntity(ArtistCreateRequest artistCreateRequest);

    Artist updateEntity(@MappingTarget Artist artist, ArtistUpdateRequest artistUpdateRequest);

    ArtistDto toDto(Artist artist);

    ArtistVo toVo(ArtistDto artistDto);
}
