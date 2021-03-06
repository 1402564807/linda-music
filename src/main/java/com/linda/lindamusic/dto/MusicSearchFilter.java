package com.linda.lindamusic.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 音乐搜索过滤器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MusicSearchFilter extends BaseSearchFilter{
    private String name = "";
}