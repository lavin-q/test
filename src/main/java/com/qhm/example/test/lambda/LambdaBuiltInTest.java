package com.qhm.example.test.lambda;
import	java.util.HashMap;
import	java.util.Map;
import	java.util.ArrayList;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * JAVA 8 四大内置函数式接口测试
 *
 * Consumer<T>： 消费型接口
 *      void accept(T t);
 *
 * Supplier<T>:供给型接口
 *      T get();
 *
 * Function<T,R>:函数型接口
 *      R apply(T t);
 *
 * Predicate<T>:断言型接口
 *      boolean test(T t);
 */
public class LambdaBuiltInTest {

    public static void main(String[] args) {
        //消费型接口测试
        Consumer<String> con = System.out::println;
        con.accept("消费型接口测试");

        //供给型接口测试
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println("供给型接口测试");
        for (Integer i : numList){
            System.out.println(i);
        }

        //函数型接口测试
        String result = strHandler("abcdef", (str) -> str.substring(2, 5));
        System.out.println("函数型接口测试");
        System.out.println(result);

        //断言型接口测试
        //过滤字符串
       List<String> list = new ArrayList<String>(){{
           add("hello");
           add("asdasd");
           add("www");
            }
        };
        System.out.println("断言型接口测试");
        List<String> strings = filterStr(list, (x) -> x.length() > 3);
        for(String s :strings){
            System.out.println(s);
        }
    }

    //供给型接口
    public static List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = sup.get();
            list.add(integer);
        }
        return list;
    }

    //函数型接口
    public static String strHandler(String str , Function<String,String> fun){
        return fun.apply(str);
    }

    //断言型接口
    public static List<String> filterStr(List<String> list , Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String s : list){
            if(pre.test(s)){
                strList.add(s);
            }
        }
        return strList;
    }

}
