package com.qhm.example.test.lambda;


import com.qhm.example.test.lambda.entity.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Lambda 练习
 */
public class LambdaExercise {

    private static List<Employee> employeeList = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,3333.33),
            new Employee("田七",8,7777.77)
    );
    /**
     * 使用Collections对员工排序
     * 规则：按年龄大小、年龄相同按姓名比较
     */
    public static void main(String[] args) {
        Collections.sort(employeeList,(e1,e2)->{
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for(Employee e : employeeList){
            System.out.println(e);
        }
    }

}
