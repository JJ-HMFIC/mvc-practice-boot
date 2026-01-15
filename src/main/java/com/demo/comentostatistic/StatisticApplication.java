package com.demo.comentostatistic;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticApplication.class, args);
    }

}
