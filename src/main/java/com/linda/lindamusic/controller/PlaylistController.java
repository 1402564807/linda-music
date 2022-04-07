package com.linda.lindamusic.controller;

import com.linda.lindamusic.dto.PlaylistCreateRequest;
import com.linda.lindamusic.dto.PlaylistSearchFilter;
import com.linda.lindamusic.dto.RecommendRequest;
import com.linda.lindamusic.mapper.PlaylistMapper;
import com.linda.lindamusic.service.PlaylistService;
import com.linda.lindamusic.vo.PlaylistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 播放列表控制器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private PlaylistService playlistService;

    private PlaylistMapper playlistMapper;


    @GetMapping("/{id}")
    public PlaylistVo get(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.get(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo create(@Validated @RequestBody PlaylistCreateRequest playlistCreateRequest) {
        return playlistMapper.toVo(playlistService.create(playlistMapper.toDto(playlistCreateRequest)));
    }

    @GetMapping
    public Page<PlaylistVo> search(@Validated PlaylistSearchFilter playlistSearchFilter) {
        return playlistService.search(playlistSearchFilter).map(playlistMapper::toVo);
    }


    @PostMapping("/{id}/recommend")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
        return playlistMapper.toVo(playlistService.recommend(id, recommendRequest.getRecommendFactor()));
    }

    @PostMapping("/{id}/cancel_recommendation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo cancelRecommendation(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.cancelRecommendation(id));
    }

    @PostMapping("/{id}/make_special")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo makeSpecial(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.makeSpecial(id));
    }

    @PostMapping("/{id}/cancel_special")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PlaylistVo cancelSpecial(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.cancelSpecial(id));
    }

    @Autowired
    public void setPlaylistMapper(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }

    @Autowired
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
}