package com.linda.lindamusic.service.Impl;

import com.auth0.jwt.JWT;
import com.linda.lindamusic.dto.TokenCreateRequest;
import com.linda.lindamusic.dto.UserCreateRequest;
import com.linda.lindamusic.dto.UserDto;
import com.linda.lindamusic.dto.UserUpdateRequest;
import com.linda.lindamusic.entity.User;
import com.linda.lindamusic.exception.BizException;
import com.linda.lindamusic.mapper.UserMapper;
import com.linda.lindamusic.repository.UserRepository;
import com.linda.lindamusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.linda.lindamusic.config.SecurityConfig.EXPIRATION_TIME;
import static com.linda.lindamusic.config.SecurityConfig.SECRET;
import static com.linda.lindamusic.exception.ExceptionType.*;
import static java.lang.System.currentTimeMillis;

/**
 * 用户服务impl
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    private PasswordEncoder passwordEncoder;

    private UserRepository repository;

    private UserMapper mapper;


    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        var user = mapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(user));
    }

    @Override
    public UserDto get(String id) {
        return mapper.toDto(getById(id));
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        return mapper.toDto(repository.save(mapper.updateEntity(getById(id), userUpdateRequest)));
    }

    private User getById(String id) {
        var user = repository.findById(id);
        if (user.isEmpty()) {
            throw new BizException(USER_NOT_FOUND);
        }
        return user.get();
    }

    @Override
    public void delete(String id) {
        repository.delete(getById(id));
    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public User loadUserByUsername(String username) {
        return super.loadUserByUsername(username);
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        var user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
            throw new BizException(USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()) {
            throw new BizException(USER_NOT_ENABLED);
        }

        if (!user.isAccountNonLocked()) {
            throw new BizException(USER_LOCKED);
        }

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
    }

    @Override
    public UserDto getCurrentUser() {
        return mapper.toDto(super.getCurrentUserEntity());
    }


    private void checkUserName(String username) {
        var user = repository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(USER_NAME_DUPLICATE);
        }
    }

    @Autowired
    public void setUserService(UserMapper userMapper) {
        this.mapper = userMapper;
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
