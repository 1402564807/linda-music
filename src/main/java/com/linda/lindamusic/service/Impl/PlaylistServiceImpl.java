package com.linda.lindamusic.service.Impl;

import com.linda.lindamusic.dto.PlaylistDto;
import com.linda.lindamusic.exception.BizException;
import com.linda.lindamusic.exception.ExceptionType;
import com.linda.lindamusic.mapper.PlaylistMapper;
import com.linda.lindamusic.repository.PlaylistRepository;
import com.linda.lindamusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 播放列表服务impl
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Service
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository repository;

    private PlaylistMapper mapper;

    @Override
    public PlaylistDto get(String id) {
        var playlist = repository.findById(id);
        if (playlist.isEmpty()) {
            throw new BizException(ExceptionType.PLAYLIST_NOT_FOUND);
        }
        return mapper.toDto(playlist.get());
    }

    @Autowired
    public void setRepository(PlaylistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(PlaylistMapper mapper) {
        this.mapper = mapper;
    }
}