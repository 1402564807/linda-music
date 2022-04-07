package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 播放列表存储库
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface PlaylistRepository extends JpaRepository<Playlist, String>, JpaSpecificationExecutor<Playlist> {
}