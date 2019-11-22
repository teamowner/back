package com.owner.backproject.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "spring.cross")
public class CrossInterceptor implements HandlerInterceptor {

    private static List<String> allowHosts;

    //配置允许跨域的域名
    public void setAllow(String allow){
        if(allow != null){
            allowHosts = Arrays.asList(allow.split(","));
        }
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String origin  = request.getHeader(HttpHeaders.ORIGIN);
        log.info("====配置:" + allowHosts);
        log.info("====:" + origin);
        if (origin != null) {
            if(allowHosts.contains(origin)) {
                response.setHeader("Access-Control-Allow-Origin", origin);
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type, X-Access-Token");
                response.setHeader("Access-Control-Max-Age", "3600");
            } else {
                log.warn("跨域失败：" + origin);
            }
        }
        return true;
    }
}
