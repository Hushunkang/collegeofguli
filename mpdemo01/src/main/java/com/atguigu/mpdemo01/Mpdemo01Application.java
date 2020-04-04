package com.atguigu.mpdemo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.mpdemo01.mapper")
public class Mpdemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Mpdemo01Application.class, args);
    }

}
