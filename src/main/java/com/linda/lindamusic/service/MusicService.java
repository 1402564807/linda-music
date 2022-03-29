package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.MusicDto;
import com.linda.lindamusic.dto.MusicSearchFilter;
import com.linda.lindamusic.entity.Music;
import org.springframework.data.domain.Page;

/**
 * @author 林思涵
 * @date 2022/03/29
 */
public interface MusicService extends GeneralService<Music, MusicDto> {

    Page<MusicDto> search(MusicSearchFilter musicSearchRequest);

    void publish(String id);

    void close(String id);
}