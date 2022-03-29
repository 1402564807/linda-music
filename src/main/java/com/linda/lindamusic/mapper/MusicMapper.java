package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.ArtistDto;
import com.linda.lindamusic.dto.MusicCreateRequest;
import com.linda.lindamusic.dto.MusicDto;
import com.linda.lindamusic.dto.MusicUpdateRequest;
import com.linda.lindamusic.entity.Music;
import com.linda.lindamusic.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 音乐映射器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Mapper(componentModel = "spring",
        uses = {FileMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MusicMapper extends MapperInterface<Music, MusicDto> {
    @Mapping(source = "fileId", target = "file.id")
    @Mapping(target = "artistList", source = "artistIds")
    MusicDto toDto(MusicCreateRequest musicCreateRequest);

    @Mapping(source = "fileId", target = "file.id")
    @Mapping(target = "artistList", source = "artistIds")
    MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

    MusicVo toVo(MusicDto musicDto);


    default List<ArtistDto> mapArtistList(List<String> artistIds) {
        List<ArtistDto> artistList = new ArrayList<>();
        for (String id : artistIds) {
            ArtistDto artistDto = new ArtistDto();
            artistDto.setId(id);
            artistList.add(artistDto);
        }
        return artistList;
    }
}