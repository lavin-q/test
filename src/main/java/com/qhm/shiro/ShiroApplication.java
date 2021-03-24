package com.qhm.shiro;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShiroApplication {

    public static void main(String[] args) {
        /*SpringApplication springApplication = new SpringApplication(ShiroApplication.class);
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        springApplication.run(args);*/
        SpringApplication.run(ShiroApplication.class, args);
    }
}
