package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.ArtistCreateRequest;
import com.linda.lindamusic.dto.ArtistDto;
import com.linda.lindamusic.dto.ArtistUpdateRequest;

import java.util.List;

public interface ArtistService {
    ArtistDto create(ArtistCreateRequest artistCreateRequest);

    ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest);

    List<ArtistDto> list();
}