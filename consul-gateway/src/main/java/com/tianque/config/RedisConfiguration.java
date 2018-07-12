package com.tianque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.net.UnknownHostException;

/**
 * Created by QQ on 2018/7/11.
 */

@Configuration
public class RedisConfiguration {
    @Bean
    @Primary
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException{
        RedisTemplate<Object, Object> template = new RedisTemplate<Object,Object>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    @Primary
    public StringRedisTemplate stringRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException{
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}
