package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.annotation.Nonnull;
import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, String>, JpaSpecificationExecutor<Music> {
    @Nonnull
    @Override
    Optional<Music> findById(@Nonnull String id);
}