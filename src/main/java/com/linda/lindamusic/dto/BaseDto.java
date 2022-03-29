package com.linda.lindamusic.dto;

import lombok.Data;

import java.util.Date;

/**
 * 基地到
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public abstract class BaseDto {
    protected String id;

    protected Date createdTime;

    protected Date updatedTime;
}