package com.jessie.onlineexaminationsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jessie.onlineexaminationsystem.mapper")
public class OnlineExaminationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineExaminationSystemApplication.class, args);
    }

}
