package com.qhm.example.test.lambda;


import com.qhm.example.test.lambda.entity.Employee;

import java.io.PrintStream;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 *
 * 注意点：当前的所要实现的方法的参数列表和返回结果要与调用方法的参数列表和返回结果一致
 * 对象：：实例方法名
 * 类：：静态方法名
 * 类：：实例方法名
 *
 *
 * 构造器引用：
 * 注意点：需要调用的构造器的参数列表和返回值类型要和函数式接口中抽象方法的参数列表保持一致
 * 必须使用类中明确声明的构造器,否则编译不通过
 * 类名：：new
 *
 * 数组引用
 * Type[]::new;
 *
 */
public class MethodRefTest {

    public static void main(String[] args) {
        /**
         * 当前的所要实现的方法的参数列表和返回结果要与调用方法的参数列表和返回结果一致
         * 对象：：实例方法名
         */
        //方式1
        Consumer<String> consumer1 = (x)->System.out.println(x);
        consumer1.accept("方式1:"+"方法引用1");
        //方式2
        PrintStream ps = System.out;
        Consumer<String> consumer2 = ps::println;
        consumer2.accept("方式2:"+"方法引用2");
        //方式3
        Consumer<String> consumer3 = System.out::println;
        consumer3.accept("方式3:"+"方法引用3");


        //构造器引用
        BiFunction<String,Integer, Employee> biFunction = Employee::new;
        Employee qhm = biFunction.apply("qhm", 23);
        System.out.println(qhm.toString());

        //数组引用
        Function<Integer,String[]> fun = String[]::new;
        String[] apply = fun.apply(10);
        System.out.println(apply.length);

    }
}
