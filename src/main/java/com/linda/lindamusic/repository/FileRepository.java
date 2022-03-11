package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}