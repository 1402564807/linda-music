package com.linda.lindamusic.service.Impl;


import com.linda.lindamusic.dto.ArtistDto;
import com.linda.lindamusic.dto.ArtistSearchFilter;
import com.linda.lindamusic.entity.Artist;
import com.linda.lindamusic.exception.ExceptionType;
import com.linda.lindamusic.mapper.ArtistMapper;
import com.linda.lindamusic.mapper.MapperInterface;
import com.linda.lindamusic.repository.ArtistRepository;
import com.linda.lindamusic.repository.specs.ArtistSpecification;
import com.linda.lindamusic.repository.specs.SearchCriteria;
import com.linda.lindamusic.repository.specs.SearchOperation;
import com.linda.lindamusic.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 艺术家服务公司
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Service
@Slf4j
public class ArtistServiceImpl extends TraceableGeneralServiceImpl<Artist, ArtistDto> implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;

    @Override
    public List<ArtistDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter) {
        var specs = new ArtistSpecification();
        // Todo: 代码重复需要重构
        specs.add(new SearchCriteria("name", artistSearchFilter.getName(), SearchOperation.MATCH));
        var sort = Sort.by(Sort.Direction.DESC, "createdTime");
        var pageable = PageRequest.of(artistSearchFilter.getPage() - 1, artistSearchFilter.getSize(), sort);
        return repository.findAll(specs, pageable).map(mapper::toDto);
    }

    @Autowired
    public void setRepository(ArtistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ArtistMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public JpaRepository<Artist, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Artist, ArtistDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.ARTIST_NOT_FOUND;
    }
}
