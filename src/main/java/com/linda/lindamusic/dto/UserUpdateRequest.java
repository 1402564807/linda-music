package com.linda.lindamusic.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 用户更新请求
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
@Schema(description = "用户更新请求类")
public class UserUpdateRequest {

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 64, message = "用户名长度应该在4个字符到64个字符之间")
    private String username;

    /**
     * 昵称
     */
    @Schema(description = "用户昵称")
    private String nickname;

    /**
     * 性别
     */
    @Schema(description = "用户性别")
    private String gender;
}