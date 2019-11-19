package com.owner.backproject.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "demo")
@PropertySource(value = "classpath:config/config.properties")
public class BackConfig {

    private String name;
    private int age;
}
