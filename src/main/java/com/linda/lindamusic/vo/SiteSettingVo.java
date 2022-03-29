package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.Storage;
import lombok.Data;

/**
 * 网站设置vo
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}