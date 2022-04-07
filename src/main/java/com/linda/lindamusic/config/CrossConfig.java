package com.linda.lindamusic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 交叉配置
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Configuration
public class CrossConfig {

    public static final String ORIGIN_PATTERN = "*";
    public static final String PATTERN = "/**";

    /**
     * 减少缩进
     *
     * @return {@link CorsFilter}
     */
    @Bean
    public CorsFilter corsFilter() {
        var config = new CorsConfiguration();
        //允许所有域名进行跨域调用
        config.addAllowedOriginPattern(ORIGIN_PATTERN);
        //允许跨越发送cookie
        config.setAllowCredentials(true);
        //放行全部原始头信息
        config.addAllowedHeader(ORIGIN_PATTERN);
        //允许所有请求方法跨域调用
        config.addAllowedMethod(ORIGIN_PATTERN);
        config.addExposedHeader(ORIGIN_PATTERN);
        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(PATTERN, config);
        return new CorsFilter(source);
    }
}