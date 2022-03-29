package com.linda.lindamusic.service;

import com.linda.lindamusic.dto.TokenCreateRequest;
import com.linda.lindamusic.dto.UserCreateRequest;
import com.linda.lindamusic.dto.UserDto;
import com.linda.lindamusic.dto.UserUpdateRequest;
import com.linda.lindamusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * 用户服务
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public interface UserService extends UserDetailsService {
    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);

    String createToken(TokenCreateRequest tokenCreateRequest);

    UserDto getCurrentUser();
}
