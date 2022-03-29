package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.ArtistDto;
import com.linda.lindamusic.dto.ArtistSearchFilter;
import com.linda.lindamusic.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 艺术家服务
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface ArtistService extends GeneralService<Artist, ArtistDto> {
    List<ArtistDto> list();

    Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter);
}