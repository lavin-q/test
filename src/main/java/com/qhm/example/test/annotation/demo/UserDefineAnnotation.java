package com.qhm.example.test.annotation.demo;
import java.lang.annotation.*;

/**
 * @ Description:自定义注解
 * @ Author: qhm
 * @ Date: 2019/12/3 13:38
 * @ Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface UserDefineAnnotation {
}
