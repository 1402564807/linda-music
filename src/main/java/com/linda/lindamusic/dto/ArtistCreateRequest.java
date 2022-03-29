package com.linda.lindamusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 艺术家创作请求
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class ArtistCreateRequest {

    /**
     * 名称
     */
    @NotBlank(message = "歌手名字不能为空")
    private String name;

    /**
     * 评论
     */
    private String remark;

    /**
     * 照片id
     */
    @NotBlank(message = "歌手照片必须上传")
    private String photoId;
}