package com.nzyjfw.o2o.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ningyinqiang
 * @date 2019/12/4 12:43
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 设置跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
