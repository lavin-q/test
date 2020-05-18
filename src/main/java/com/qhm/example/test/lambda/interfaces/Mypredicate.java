package com.qhm.example.test.lambda.interfaces;


/**
 * 接口:有且仅有一个抽象方法的接口，可以使用lambda表达式语法
 */
public interface Mypredicate<T> {

    boolean test(T t);
}
