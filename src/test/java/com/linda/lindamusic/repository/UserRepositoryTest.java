package com.linda.lindamusic.repository;

import com.linda.lindamusic.entity.User;
import com.linda.lindamusic.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("linda");
        user.setNickname("143");
        user.setPassword("123123123");
        user.setGender(Gender.MALE);
        user.setLocked(false);
        user.setEnabled(true);
        user.setLastLoginIp("127.0.0.1");
        user.setLastLoginTime(new Date());

//        User saveUser = repository.save(user);

        User linda = repository.getByUsername("linda");

        System.out.println(linda.toString());
    }
}