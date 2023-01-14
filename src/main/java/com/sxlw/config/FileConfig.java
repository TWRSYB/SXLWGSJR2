package com.sxlw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Value("${fileDir.actressHomePath}")
    private String actressHomePath;

    @Value("${fileDir.fanhaoHomePath}")
    private String fanhaoHomePath;



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/actressHomePath/**").addResourceLocations("file:E:\\00.日本女优/");
        registry.addResourceHandler("/fanhaoHomePath/**").addResourceLocations("file:E:\\00.日本无码/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
