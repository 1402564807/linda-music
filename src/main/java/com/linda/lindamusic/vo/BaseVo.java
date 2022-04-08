package com.linda.lindamusic.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基地vo
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public abstract class BaseVo {
    private String id;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private LocalDateTime createdTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private LocalDateTime updatedTime;
}