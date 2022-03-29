package com.linda.lindamusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 文件上传请求
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class FileUploadRequest {

    @NotBlank(message = "文件名不能为空")
    private String name;
    
    private Long size;

    @NotBlank(message = "后缀名不能为空")
    private String ext;

    @NotBlank(message = "key不能为空")
    private String key;
}