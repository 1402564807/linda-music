package com.linda.lindamusic.vo;

import com.linda.lindamusic.enums.Gender;
import lombok.Data;

import java.util.List;

/**
 * 用户vo
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
public class UserVo {
    private String id;

    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private List<RoleVo> roles;
}
