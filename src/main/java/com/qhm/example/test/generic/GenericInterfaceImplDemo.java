package com.qhm.example.test.generic;

import lombok.extern.slf4j.Slf4j;

/**
 * @ Description:泛型接口实现了类--
 * @ Author: qhm
 * @ Date: 2019/11/27 15:55
 * @ Version: 1.0
 */
@Slf4j
public class GenericInterfaceImplDemo<T> implements GenericInterfaceDemo<T> {
/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class GenericInterfaceImplDemo<T> implements GenericInterfaceDemo<T>{
 * 如果不声明泛型，如：class GenericInterfaceImplDemo implements GenericInterfaceDemo<T>，编译器会报错："Unknown class"
 */

/**
 * 传入泛型实参时：
 * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口GenericInterfaceDemo<T>
 * 但是我们可以为T传入无数个实参，形成无数种类型的GenericInterfaceDemo接口。
 * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
 * 即：Generator<T>，public T next();中的的T都要替换成传入的String类型。
 */

    @Override
    public T next(T key) {
        return key;
    }

    public void showKeyValue(GenericClassDemo<T> number){
        log.info("泛型测试 key class name is {}" , number.getKey().getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericInterfaceImplDemo g = new GenericInterfaceImplDemo();
        log.info("the key type is {}",g.next("aa").getClass().getSimpleName());

        GenericClassDemo<String> gInteger = new GenericClassDemo<>("aaaaaaaaaaaaaa");
        g.showKeyValue(gInteger);

    }
}
