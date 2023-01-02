package com.sxlw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@MapperScan("com.sxlw.mapper")
public class Sxlwgsjr2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sxlwgsjr2Application.class, args);
    }

}
