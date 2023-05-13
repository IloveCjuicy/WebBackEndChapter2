package com.example.webbackendexperiment2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.example.webbackendexperiment2.Mapper")
@EnableCaching
public class WebBackEndExperiment2Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebBackEndExperiment2Application.class, args);
    }
}
