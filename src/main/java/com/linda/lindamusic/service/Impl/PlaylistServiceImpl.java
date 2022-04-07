package com.linda.lindamusic.service.Impl;

import com.linda.lindamusic.dto.PlaylistDto;
import com.linda.lindamusic.dto.PlaylistSearchFilter;
import com.linda.lindamusic.entity.Playlist;
import com.linda.lindamusic.exception.ExceptionType;
import com.linda.lindamusic.mapper.MapperInterface;
import com.linda.lindamusic.mapper.PlaylistMapper;
import com.linda.lindamusic.repository.PlaylistRepository;
import com.linda.lindamusic.repository.specs.PlaylistSpecification;
import com.linda.lindamusic.repository.specs.SearchCriteria;
import com.linda.lindamusic.repository.specs.SearchOperation;
import com.linda.lindamusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 播放列表服务impl
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Service
public class PlaylistServiceImpl extends TraceableGeneralServiceImpl<Playlist, PlaylistDto> implements PlaylistService {

    public static final String NAME = "name";
    public static final String RECOMMENDED = "recommended";
    public static final String SPECIAL = "special";
    private PlaylistRepository repository;

    private PlaylistMapper mapper;

    @Override
    public Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter) {
        var specs = new PlaylistSpecification();
        specs.add(new SearchCriteria(NAME, playlistSearchFilter.getName(), SearchOperation.MATCH));
        if (playlistSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria(RECOMMENDED, playlistSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }

        if (playlistSearchFilter.getSpecial() != null) {
            specs.add(new SearchCriteria(SPECIAL, playlistSearchFilter.getSpecial(), SearchOperation.EQUAL));
        }
        return repository.findAll(specs, playlistSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public PlaylistDto recommend(String id, Integer recommendFactor) {
        var playlist = getEntity(id);
        playlist.setRecommended(true);
        playlist.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto cancelRecommendation(String id) {
        var playlist = getEntity(id);
        playlist.setRecommended(false);
        playlist.setRecommendFactor(0);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto makeSpecial(String id) {
        var playlist = getEntity(id);
        playlist.setSpecial(true);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto cancelSpecial(String id) {
        var playlist = getEntity(id);
        playlist.setSpecial(false);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public JpaRepository<Playlist, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Playlist, PlaylistDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.PLAYLIST_NOT_FOUND;
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