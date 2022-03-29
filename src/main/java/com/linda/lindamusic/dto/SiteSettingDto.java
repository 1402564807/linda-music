package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.Storage;
import lombok.Data;

/**
 * 网站设置dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}