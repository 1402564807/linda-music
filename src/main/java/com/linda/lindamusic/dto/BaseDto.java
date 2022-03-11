package com.linda.lindamusic.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseDto {
    protected String id;

    protected Date createdTime;

    protected Date updatedTime;
}