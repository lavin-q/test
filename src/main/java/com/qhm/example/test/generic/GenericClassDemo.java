package com.qhm.example.test.generic;

import lombok.extern.slf4j.Slf4j;

/**
 * @ Description: 泛型类示例-再编译期限制类型
 * @ Author: qhm
 * @ Date: 2019/11/27 14:33
 * @ Version: 1.0
 */
@Slf4j
public class GenericClassDemo<T> {

        //key这个成员变量的类型为T,T的类型由外部指定
        private T key;

        public GenericClassDemo(T key){
            this.key = key;
        }

        public T getKey() {
            return key;
        }





}
