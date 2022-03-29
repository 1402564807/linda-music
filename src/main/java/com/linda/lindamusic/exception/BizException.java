package com.linda.lindamusic.exception;

import lombok.Getter;

/**
 * 商业例外
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Getter
public class BizException extends RuntimeException {
    private final Integer code;

    public BizException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }
}
