package com.linda.lindamusic.exception;

import lombok.Data;

/**
 * 错误响应
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class ErrorResponse {
    private Integer code;

    private String message;

    private Object trace;
}
