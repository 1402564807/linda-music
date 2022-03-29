package com.linda.lindamusic.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信配置
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Configuration
public class WeChatConfig {

    @Value("${wechat.mp.app-id}")
    private String appId;

    @Value("${wechat.mp.app-secret}")
    private String appSecret;

    /**
     * WX MP服务
     *
     * @return {@link WxMpService}
     */
    @Bean
    public WxMpService wxMpService() {
        var wxMpService = new WxMpServiceImpl();
        var config = new WxMpDefaultConfigImpl();
        config.setAppId(appId);
        config.setSecret(appSecret);
        wxMpService.setWxMpConfigStorage(config);
        return wxMpService;
    }
}