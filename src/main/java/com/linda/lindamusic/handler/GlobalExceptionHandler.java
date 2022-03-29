package com.linda.lindamusic.handler;

import com.linda.lindamusic.exception.ExceptionType;
import com.linda.lindamusic.exception.BizException;
import com.linda.lindamusic.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局异常处理程序
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常处理程序
     *
     * @param e E
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse bizExceptionHandler(BizException e) {
        var errorResponse = new ErrorResponse();
        errorResponse.setCode(e.getCode());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTrace(e.getStackTrace());
        log.error(e.getMessage());
        return errorResponse;
    }

    /**
     * 异常处理程序
     *
     * @param e E
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse exceptionHandler(Exception e) {
        var errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionType.INNER_ERROR.getCode());
        errorResponse.setMessage(ExceptionType.INNER_ERROR.getMessage());
        e.printStackTrace();
        log.error(e.getMessage());
        return errorResponse;
    }

    /**
     * 拒绝访问处理程序
     *
     * @param e E
     * @return {@link ErrorResponse}
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public ErrorResponse accessDeniedHandler(Exception e) {
        var errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionType.FORBIDDEN.getCode());
        errorResponse.setMessage(ExceptionType.FORBIDDEN.getMessage());
        e.printStackTrace();
        log.error(e.getMessage());
        return errorResponse;
    }

    /**
     * 业务异常处理程序
     *
     * @param e E
     * @return {@link List}<{@link ErrorResponse}>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public List<ErrorResponse> bizExceptionHandler(MethodArgumentNotValidException e) {
        var errorResponses = new ArrayList<ErrorResponse>();
        e.printStackTrace();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode(ExceptionType.BAD_REQUEST.getCode());
            errorResponse.setMessage(error.getDefaultMessage());
            errorResponses.add(errorResponse);
            log.error(e.getMessage());
        });
        return errorResponses;
    }
}
