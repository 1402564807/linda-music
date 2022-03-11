package com.linda.lindamusic.config;

import com.linda.lindamusic.exception.RestAuthenticationEntryPoint;
import com.linda.lindamusic.filter.JwtAuthorizationFilter;
import com.linda.lindamusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String SECRET = "LindaMusic";
    public static final Long EXPIRATION_TIME = 864000000L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CREATE_TOKEN_URL = "/tokens";
    public static final String SITE_SETTING_URL = "/settings/site";
    public static final String WECHAT_URL = "/wechat/**";
    public static final String PLAYLISTS_URL = "/playlists/**";
    public static final String[] SWAGGER_WHITELIST = {
            "/swagger**/**",
            "/v3/**",
            "/webjars/**",
            "/doc.html",
    };

    private UserService userService;

    private RestAuthenticationEntryPoint entryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(CREATE_TOKEN_URL).permitAll()
                .antMatchers(SWAGGER_WHITELIST).permitAll()
                .antMatchers(SITE_SETTING_URL).permitAll()
                .antMatchers(PLAYLISTS_URL).permitAll()
                .antMatchers(WECHAT_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userService))
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Autowired
    public void setEntryPoint(RestAuthenticationEntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
