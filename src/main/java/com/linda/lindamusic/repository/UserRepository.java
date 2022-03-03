package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Nonnull;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    @Nonnull
    @Override
    User getById(@Nonnull String id);

    @Nonnull
    @Override
    Page<User> findAll(@Nonnull Pageable pageable);
}
