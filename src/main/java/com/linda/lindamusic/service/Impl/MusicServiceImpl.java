package com.linda.lindamusic.service.Impl;


import com.linda.lindamusic.dto.MusicDto;
import com.linda.lindamusic.dto.MusicSearchFilter;
import com.linda.lindamusic.entity.Music;
import com.linda.lindamusic.enums.MusicStatus;
import com.linda.lindamusic.exception.ExceptionType;
import com.linda.lindamusic.mapper.MapperInterface;
import com.linda.lindamusic.mapper.MusicMapper;
import com.linda.lindamusic.repository.MusicRepository;
import com.linda.lindamusic.repository.specs.MusicSpecification;
import com.linda.lindamusic.repository.specs.SearchCriteria;
import com.linda.lindamusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import static com.linda.lindamusic.enums.MusicStatus.PUBLISHED;
import static com.linda.lindamusic.repository.specs.SearchOperation.MATCH;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.data.domain.Sort.by;

/**
 * 音乐服务impl
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Service
public class MusicServiceImpl extends GeneralServiceImpl<Music, MusicDto> implements MusicService {

    public static final String NAME = "name";
    public static final String CREATED_TIME = "createdTime";

    private MusicRepository repository;

    private MusicMapper mapper;

    @Override
    public Page<MusicDto> search(MusicSearchFilter musicSearchRequest) {
        if (musicSearchRequest == null) {
            musicSearchRequest = new MusicSearchFilter();
        }
        var specs = new MusicSpecification();
        specs.add(new SearchCriteria(NAME, musicSearchRequest.getName(), MATCH));
        var sort = by(DESC, CREATED_TIME);
        var pageable = of(musicSearchRequest.getPage() - 1, musicSearchRequest.getSize(), sort);
        return repository.findAll(specs, pageable).map(mapper::toDto);
    }

    @Override
    public void publish(String id) {
        var music = getEntity(id);
        music.setStatus(PUBLISHED);
        repository.save(music);
    }


    @Override
    public void close(String id) {
        var music = getEntity(id);
        music.setStatus(MusicStatus.CLOSED);
        repository.save(music);
    }


    @Autowired
    public void setRepository(MusicRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(MusicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public JpaRepository<Music, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Music, MusicDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.MUSIC_NOT_FOUND;
    }
}
