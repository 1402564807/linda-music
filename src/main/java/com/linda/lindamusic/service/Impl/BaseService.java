package com.linda.lindamusic.service.Impl;

import com.linda.lindamusic.entity.User;
import com.linda.lindamusic.exception.BizException;
import com.linda.lindamusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static com.linda.lindamusic.exception.ExceptionType.USER_NOT_FOUND;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

/**
 * 基本服务
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public abstract class BaseService {

    private UserRepository userRepository;

    protected User getCurrentUserEntity() {
        var authentication = getContext().getAuthentication();
        return loadUserByUsername(authentication.getName());
    }

    protected User loadUserByUsername(String username) {
        var user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new BizException(USER_NOT_FOUND);
        }
        return user.get();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
