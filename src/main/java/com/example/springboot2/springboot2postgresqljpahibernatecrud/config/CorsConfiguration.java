package com.example.springboot2.springboot2postgresqljpahibernatecrud.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
