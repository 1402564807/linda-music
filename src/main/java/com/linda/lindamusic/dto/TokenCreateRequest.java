package com.linda.lindamusic.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Schema(description = "创建token")
public class TokenCreateRequest {

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空!")
    @Size(min = 4, max = 64, message = "用户名长度应该在4个字符到64个字符之间!")
    private String username;

    @Schema(description = "用户密码")
    @NotBlank(message = "用户名不能为空!")
    @Size(min = 6, max = 64, message = "密码长度应该在4个字符到64个字符之间!")
    private String password;
}
