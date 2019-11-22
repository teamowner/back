package com.owner.backproject.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Slf4j
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CrossInterceptor()).addPathPatterns("/**");
        log.debug("跨域拦截器注册成功！");


        registry.addInterceptor(new OptionsInterceptor()).addPathPatterns("/**");
        log.debug("Options请求拦截器注册成功！");
    }

    // 不在这里实现跨域，这里实现跨域会导致拦截器return false的情况下跨域失败，改为拦截器实现
    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("X-Access-Token");
        log.debug("允许跨域配置成功！");
    }
   */
}
