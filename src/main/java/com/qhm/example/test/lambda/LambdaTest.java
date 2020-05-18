package com.qhm.example.test.lambda;


import com.qhm.example.test.lambda.entity.Employee;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Lambda 表达式语法测试
 */
public class LambdaTest {

    public static void main(String[] args) {
        //无参无返回值
        Runnable runnable = ()->System.out.println("Hello lambda");
        //Runnable runnable = ()->System.out.println("Hello lambda");效果等同于
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda");
            }
        };
        runnable.run();
        runnable1.run();

        //单参数无返回值
        Consumer<String> con = (x)->System.out.println(x);  //对 Consumer.accept(T t) 的实现
        con.accept("单个参数无返回值");
        Consumer<String> con1 = x-> System.out.println(x);
        con1.accept("单个参数无返回值,省略参数括号");


        //多参数，Lambda体多行，有返回值
        Comparator<Integer> comparator = (x,y)->{
            System.out.println("多参数，Lambda体多行，有返回值");
            return Integer.compare(x,y);
        };

        int compare = comparator.compare(1, 2);
        System.out.println(compare);

        //多参数，有返回值，无其他函数体
        Comparator<Integer> comparator1 = Integer::compare;
        int compare1 = comparator1.compare(4,2);
        System.out.println(compare1);



    }

}
