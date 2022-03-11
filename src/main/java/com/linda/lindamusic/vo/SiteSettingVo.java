package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}