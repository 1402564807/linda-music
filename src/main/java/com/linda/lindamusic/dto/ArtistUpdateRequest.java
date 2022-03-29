package com.linda.lindamusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 艺术家更新请求
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class ArtistUpdateRequest {

    @NotBlank(message = "歌手名字不能为空")
    private String name;

    private String remark;

    @NotBlank(message = "歌手照片必须上传")
    private String photoId;
}