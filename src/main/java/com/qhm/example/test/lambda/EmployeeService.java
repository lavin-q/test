package com.qhm.example.test.lambda;


import com.qhm.example.test.lambda.entity.Employee;
import com.qhm.example.test.lambda.interfaces.Mypredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 对Emloyee 操作
 */
public class EmployeeService {
    //实例化一个EmployeeList
    private static List<Employee> employeeList = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,3333.33),
            new Employee("田七",8,7777.77)
    );

    // 过滤并返回员工列表
    public static List<Employee> filterEmployee(List<Employee> list,Mypredicate<Employee> mypredicate){
        List<Employee> emps = new ArrayList<>();
        for(Employee employee : list ){
            if(mypredicate.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }

    public static void main(String[] args) {

        System.out.println("-------------------------------------------年龄大于30----------------------------------------------------------");
        //需求一：查找出年龄大于30的员工(自定义单抽象方法接口，使用lambda表达式)
        List<Employee> employees = filterEmployee(employeeList, (e) -> e.getAge() > 30);
        //输出员工信息
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
        //list Stream
        employeeList.stream().filter((e) -> e.getAge() > 30).forEach(System.out::println);

        //获取所有人名
        employeeList.stream().map(Employee::getName).forEach(System.out::println);


        //
    }










}
