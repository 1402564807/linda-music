package com.linda.lindamusic.controller;

import com.linda.lindamusic.dto.UserCreateRequest;
import com.linda.lindamusic.dto.UserUpdateRequest;
import com.linda.lindamusic.mapper.UserMapper;
import com.linda.lindamusic.service.UserService;
import com.linda.lindamusic.vo.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@CrossOrigin
@RestController
@Tag(name = "用户")
@RequestMapping("users")
public class UserController {

    private UserService userService;

    private UserMapper userMapper;

    @GetMapping
    @Operation(summary = "用户检索")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Page<UserVo> search(@PageableDefault(sort = {"createdTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVo);
    }

    @PostMapping
    @Operation(summary = "创建新用户")
    public UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    @GetMapping("{id}")
    @Operation(summary = "根据ID获取用户数据")
    public UserVo get(@Parameter(description = "用户ID") @PathVariable String id) {
        return userMapper.toVo(userService.get(id));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "根据ID更新用户数据")
    public UserVo update(@Parameter(description = "用户ID") @PathVariable String id,
                         @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVo(userService.update(id, userUpdateRequest));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "根据ID删除用户")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@Parameter(description = "用户ID") @PathVariable String id) {
        userService.delete(id);
    }

    @GetMapping("/me")
    public UserVo me() {
        return userMapper.toVo(userService.getCurrentUser());
    }

    @Autowired
    public void setUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
