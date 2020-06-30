package com.klayzz.mybatissource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MybatisSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSourceApplication.class, args);
    }

}
