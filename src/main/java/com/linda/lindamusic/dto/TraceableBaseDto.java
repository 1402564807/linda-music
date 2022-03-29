package com.linda.lindamusic.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 可追踪基本dto
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TraceableBaseDto extends BaseDto {
    private UserDto createdBy;

    private UserDto updatedBy;
}