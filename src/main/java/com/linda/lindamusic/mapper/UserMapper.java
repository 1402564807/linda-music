package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.UserCreateRequest;
import com.linda.lindamusic.dto.UserDto;
import com.linda.lindamusic.dto.UserUpdateRequest;
import com.linda.lindamusic.entity.User;
import com.linda.lindamusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
