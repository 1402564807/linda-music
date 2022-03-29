package com.linda.lindamusic.dto;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * 基本搜索筛选器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class BaseSearchFilter {
    @Min(value = 1, message = "page最小值为1")
    private Integer page = 1;

    @Min(value = 0, message = "page最小值为1")
    private Integer size = 10;
}
