package com.linda.lindamusic.service.Impl;

import com.linda.lindamusic.dto.SiteSettingDto;
import com.linda.lindamusic.service.FileService;
import com.linda.lindamusic.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 设置服务impl
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Service
public class SettingServiceImpl implements SettingService {

    @Value("${cos.bucket}")
    private String bucket;


    @Value("${cos.region}")
    private String region;


    private FileService fileService;


    @Override
    public SiteSettingDto getSiteSetting() {
        var siteSettingDto = new SiteSettingDto();
        siteSettingDto.setBucket(bucket);
        siteSettingDto.setRegion(region);
        siteSettingDto.setStorage(fileService.getDefaultStorage());
        return siteSettingDto;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}
