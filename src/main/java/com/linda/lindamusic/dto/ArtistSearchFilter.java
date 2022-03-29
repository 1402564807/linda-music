package com.linda.lindamusic.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 艺术家搜索过滤器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArtistSearchFilter extends BaseSearchFilter {
    private String name = "";
}