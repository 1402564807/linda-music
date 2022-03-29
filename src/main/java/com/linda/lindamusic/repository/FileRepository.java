package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 文件库
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface FileRepository extends JpaRepository<File, String> {
}