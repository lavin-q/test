package com.qhm.example.test.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ Description:
 * @ Author: qhm
 * @ Date: 2019/12/30 11:10
 * @ Version: 1.0
 */
public class TestConfigurationMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration1.class);

        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();
        System.out.println(tb);

        TestBean tb2 = (TestBean) context.getBean("testBean");
        tb2.sayHello();
        System.out.println(tb2);
    }


}
