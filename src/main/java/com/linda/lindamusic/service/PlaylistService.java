package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.PlaylistDto;

/**
 * 播放列表服务
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface PlaylistService {
    PlaylistDto get(String id);
}