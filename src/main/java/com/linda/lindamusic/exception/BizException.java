package com.linda.lindamusic.exception;

import com.linda.lindamusic.enums.ExceptionType;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
    private final Integer code;

    public BizException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }
}
