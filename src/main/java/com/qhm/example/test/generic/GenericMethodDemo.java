package com.qhm.example.test.generic;

import lombok.extern.slf4j.Slf4j;

/**
 * @ Description: 泛型方法示例
 * @ Author: qhm
 * @ Date: 2019/11/28 10:18
 * @ Version: 1.0
 */
@Slf4j
public class GenericMethodDemo {

    public <T> T showKeyName(GenericClassDemo<T> g){
        log.info("the key name is {}",g.getKey());
        return g.getKey();
    }


    public static void main(String[] args) {
        Apple apple = new Apple();
        Person person = new Person();
        GenerateTest<Fruit> generateTest = new GenerateTest<>();

        //apple是Fruit的子类，所以这里可以
        generateTest.show_1(apple);
        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        //generateTest.show_1(person);

        //使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);

        //使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);

        //
        //generateTest.show_4(generateTest);
        //generateTest.show_5(generateTest);


        GenerateTest<Fruit> generate1 = new GenerateTest<>(new Apple());
        generate1.setKey(new Fruit());
        generate1.show_4(generateTest);
    }


}
class Fruit{
    @Override
    public String toString() {
        return "fruit";
    }
}

class Apple extends Fruit{
    @Override
    public String toString() {
        return "apple";
    }
}

class Person{
    @Override
    public String toString() {
        return "Person";
    }
}

@Slf4j
class GenerateTest<T extends Object> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public GenerateTest(T key){
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key){
        this.key = key;
    }

    public GenerateTest(){}

    //不是一个泛型方法，其中的T只能和泛型类中声明的T同类型
    public void show_1(T t) {
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
    //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
    public <E> E show_3(E t){
        System.out.println(t.toString());
        return null;
    }

    //在泛型类中声明了一个泛型方法，使用泛型K，注意这个T是一种全新的类型，可以与泛型类中声明的K不是同一种类型。
    public <K> void show_2(K t){
        System.out.println(t.toString());
    }

    //为泛型添加上边界.
    public <K extends Fruit> K show_4(GenerateTest<? extends Fruit> f){
        log.info("the class name is {}",f.getClass().getSimpleName());
        K t = (K)f.getKey();
        log.info("the return value is {}",t);
        log.info("the return class name is {}",t.getClass().getSimpleName());
        return t;
    }

    public <K> K show_5(GenerateTest<? super Apple> f){
        log.info("the class name is {}",f.getClass().getSimpleName());
        return null;
    }

    public <T> void printMsg( T... args){
        for(T t : args){
           log.info("泛型测试:t is {}",t);
        }
    }

}