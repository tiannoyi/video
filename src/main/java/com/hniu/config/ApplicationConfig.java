package com.hniu.config;

import com.hniu.entity.System;
import com.hniu.entity.SystemExample;
import com.hniu.mapper.SystemMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ApplicationConfig {


    @Bean
    public System system(SystemMapper sm) {
        try {
            SystemExample example = new SystemExample();
            example.setOrderByClause("sustem_id desc");
            List<System> systems = sm.selectByExample(example);
            System system = systems.get(0);
            return system;
        } catch (Exception e) {
           // return new System(1, "图书管理系统", "/img/icon.icon", new Byte("10"), "appid", "appsecret", "HNIUBS",new Float(0));
            return new System(1,"视频管理系统","","","appsecret","appid",new Byte("10"));
        }
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                /*registry.addMapping("/**").allowedOrigins("http://localhost:8080", "http://127.0.0.1:8020")
                        .allowedMethods("*").allowCredentials(true);*/
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("*").allowCredentials(true);
            }
        };
    }
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

}
