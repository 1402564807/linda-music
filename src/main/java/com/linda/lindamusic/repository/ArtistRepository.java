package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * 艺术家库
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface ArtistRepository extends JpaRepository<Artist, String>, JpaSpecificationExecutor<Artist> {
    @Nonnull
    Optional<Artist> findById(@Nonnull String id);
}