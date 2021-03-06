package com.linda.lindamusic.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * 微信控制器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    private WxMpService wxMpService;

    @GetMapping("/auth_url")
    public String getAuthUrl(@PathParam("redirectUrl") String redirectUrl) {
        return wxMpService.getOAuth2Service().buildAuthorizationUrl(
                redirectUrl,
                WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                null
        );
    }


    @Autowired
    public void setWxMpService(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }
}