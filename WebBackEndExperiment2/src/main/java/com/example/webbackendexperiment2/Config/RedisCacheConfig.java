package com.example.webbackendexperiment2.Config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;


import java.time.Duration;


@Configuration
public class RedisCacheConfig  extends CachingConfigurerSupport {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){

        //三种序列化方式，默认使用的序列化方式是JdkSerializationRedisSerializer
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();

        //修改序列化方式为GenericJackson2JsonRedisSerializer
        //configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair
        //        .fromSerializer(new GenericJackson2JsonRedisSerializer()))
        //       .entryTtl(Duration.ofMinutes(2));

        //修改序列化方式为标准json则设置Jackson2JsonRedisSerializer<>(Object.class)
        //  configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair
        //         .fromSerializer(new Jackson2JsonRedisSerializer<>(Object.class)))
        //         .entryTtl(Duration.ofMinutes(2));

        return configuration;
    }
}