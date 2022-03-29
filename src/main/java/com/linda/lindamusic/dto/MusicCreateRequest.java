package com.linda.lindamusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 音乐创作请求
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class MusicCreateRequest {
    @NotBlank(message = "歌曲名不能为空")
    private String name;

    private String description;

    private String fileId;

    @NotNull(message = "歌手未选择")
    private List<String> artistIds;
}