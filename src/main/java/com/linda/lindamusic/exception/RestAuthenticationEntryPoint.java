package com.linda.lindamusic.exception;

import cn.hutool.json.JSONUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * rest身份验证入口点
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        var errorResponse = new ErrorResponse();
        errorResponse.setCode(ExceptionType.UNAUTHORIZED.getCode());
        errorResponse.setMessage(ExceptionType.UNAUTHORIZED.getMessage());
        response.getWriter().println(JSONUtil.parse(errorResponse));
        response.getWriter().flush();
    }
}
