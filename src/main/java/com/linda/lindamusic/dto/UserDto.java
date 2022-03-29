package com.linda.lindamusic.dto;

import com.linda.lindamusic.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class UserDto {
    private String id;

    private String username;

    private String nickname;

    private List<RoleDto> roles;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;
}
