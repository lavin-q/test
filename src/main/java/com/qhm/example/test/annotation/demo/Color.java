package com.qhm.example.test.annotation.demo;
import java.lang.annotation.*;

/**
 * @ Description:
 * @ Author: qhm
 * @ Date: 2019/12/3 13:55
 * @ Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Color {

    String value();

}
