package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.PlaylistDto;
import com.linda.lindamusic.dto.PlaylistSearchFilter;
import com.linda.lindamusic.entity.Playlist;
import org.springframework.data.domain.Page;

/**
 * 播放列表服务
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {
    Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

    PlaylistDto recommend(String id, Integer recommendFactor);

    PlaylistDto cancelRecommendation(String id);

    PlaylistDto makeSpecial(String id);

    PlaylistDto cancelSpecial(String id);
}