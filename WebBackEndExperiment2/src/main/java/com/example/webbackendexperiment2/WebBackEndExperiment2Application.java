package com.example.webbackendexperiment2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.example.webbackendexperiment2.Mapper")
public class WebBackEndExperiment2Application {

    public static void main(String[] args) {
        SpringApplication.run(WebBackEndExperiment2Application.class, args);
    }

}
