package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.SiteSettingDto;
import com.linda.lindamusic.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}