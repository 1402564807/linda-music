package com.linda.lindamusic.dto;

import lombok.Data;

@Data
public class MusicSearchFilter {
    private String name = "";

    private Integer page = 1;

    private Integer size = 10;
}