package com.linda.lindamusic.repository.specs;

/**
 * 搜索操作
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public enum SearchOperation {
    GREATER_THAN,
    LESS_THAN,
    GREATER_THAN_EQUAL,
    LESS_THAN_EQUAL,
    NOT_EQUAL,
    EQUAL,
    MATCH,
    MATCH_START,
    MATCH_END,
    IN,
    NOT_IN
}