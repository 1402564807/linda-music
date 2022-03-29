package com.linda.lindamusic.vo;

import lombok.Data;

/**
 * 文件上传vo
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class FileUploadVo {
    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String fileId;

    private Long startTime;

    private Long expiredTime;
}