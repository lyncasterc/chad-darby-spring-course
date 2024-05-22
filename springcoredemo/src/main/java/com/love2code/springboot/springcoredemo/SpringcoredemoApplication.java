package com.love2code.springboot.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
* enabling component scanning for outside packages
*
* @SpringBootApplication(
*   scanBasePackages = {"com.love2code.springboot.springcoredemo", "com.love2code.springboot.springcoredemo.common"}
*
* you can list packages in the scanBasePackages array
* )
* */
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}
