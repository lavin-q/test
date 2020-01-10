package com.qhm.example.test.annotation.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @ Description: 形状类
 * @ Author: qhm
 * @ Date: 2019/12/3 13:52
 * @ Version: 1.0
 */
@Setter
@Getter
@Slf4j
public class Shape {

    @Color("red")
    private String color;

    @Line(line = 5)
    private int line;

    @Line(lines = 8)
    private int lines;

    @Override
    public String toString(){
        log.info("定义形状和颜色:{}",color+","+line);
        return color+","+line;
    }

}
