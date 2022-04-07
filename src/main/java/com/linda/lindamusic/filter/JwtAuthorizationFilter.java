package com.linda.lindamusic.filter;

import com.linda.lindamusic.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.auth0.jwt.JWT.require;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.linda.lindamusic.config.SecurityConfig.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

/**
 * jwt授权过滤器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    @Resource
    private UserService userService;

    /**
     * jwt授权过滤器
     *
     * @param authenticationManager 身份验证管理器
     * @param userService           用户服务
     */
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }

    /**
     * 内部过滤器
     *
     * @param request  要求
     * @param response 回答
     * @param chain    链条
     * @throws IOException      IO异常
     * @throws ServletException servlet异常
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        var header = request.getHeader(HEADER_STRING);
        if (isNull(header) || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        var authenticationToken = getAuthentication(header);
        getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    /**
     * 获取身份验证
     *
     * @param header 标题
     * @return {@link UsernamePasswordAuthenticationToken}
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String header) {
        if (nonNull(header)) {
            var username = require(HMAC512(SECRET.getBytes(UTF_8)))
                    .build()
                    .verify(header.replace(TOKEN_PREFIX, ""))
                    .getSubject();
            if (nonNull(username)) {
                var user = userService.loadUserByUsername(username);
                return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
            }
        }
        return null;
    }
}
