package com.qhm.example.test.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @ Description:
 * @ Author: qhm
 * @ Date: 2019/12/19 13:21
 * @ Version: 1.0
 */
@Configuration
@Slf4j
public class TestConfiguration1 {

    public TestConfiguration1(){
       log.info("TestConfiguration容器启动初始化。。。");
       System.out.println("TestConfiguration容器启动初始化。。。");
    }

    @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
    @Scope("prototype")
    public TestBean testBean() {
        return new TestBean();
    }
}
