package com.linda.lindamusic.service.Impl;

import com.linda.lindamusic.dto.PlaylistDto;
import com.linda.lindamusic.entity.Playlist;
import com.linda.lindamusic.exception.ExceptionType;
import com.linda.lindamusic.exception.BizException;
import com.linda.lindamusic.mapper.PlaylistMapper;
import com.linda.lindamusic.repository.PlaylistRepository;
import com.linda.lindamusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository repository;

    private PlaylistMapper mapper;

    @Override
    public PlaylistDto get(String id) {
        Optional<Playlist> playlist = repository.findById(id);
        if (!playlist.isPresent()) {
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