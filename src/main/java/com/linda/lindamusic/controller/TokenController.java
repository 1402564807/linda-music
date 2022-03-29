package com.linda.lindamusic.controller;

import com.linda.lindamusic.dto.TokenCreateRequest;
import com.linda.lindamusic.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 令牌控制器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@RestController
@Tag(name = "获取token")
@RequestMapping("tokens")
public class TokenController {

    private UserService userService;

    /**
     * 创造
     *
     * @param tokenCreateRequest 令牌创建请求
     * @return {@link String}
     */
    @PostMapping
    @Operation(summary = "根据用户信息创建新token")
    public String create(@RequestBody TokenCreateRequest tokenCreateRequest) {
        return userService.createToken(tokenCreateRequest);
    }

    /**
     * 设置用户服务
     *
     * @param userService 用户服务
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
