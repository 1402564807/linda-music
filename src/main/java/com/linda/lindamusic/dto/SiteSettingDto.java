package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}