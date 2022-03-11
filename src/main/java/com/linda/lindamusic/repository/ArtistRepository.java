package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Nonnull;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, String> {
    @Nonnull
    Optional<Artist> findById(@Nonnull String id);
}