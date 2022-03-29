package com.linda.lindamusic.mapper;

import com.linda.lindamusic.dto.SiteSettingDto;
import com.linda.lindamusic.vo.SiteSettingVo;
import org.mapstruct.Mapper;

/**
 * 站点设置映射器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}