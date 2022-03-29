package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * 音乐库
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface MusicRepository extends JpaRepository<Music, String>, JpaSpecificationExecutor<Music> {
    @Nonnull
    @Override
    Optional<Music> findById(@Nonnull String id);
}