package com.linda.lindamusic.repository.specs;

import lombok.Data;

/**
 * 搜索条件
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;

    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }
}