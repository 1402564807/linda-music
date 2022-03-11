package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}