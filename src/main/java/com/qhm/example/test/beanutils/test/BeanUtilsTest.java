package com.qhm.example.test.beanutils.test;

import org.springframework.beans.BeanUtils;

/**
 *
 * @Description:    测试BeanUtils中相关方法
 * @Author:         qhm
 * @CreateDate:     2019/7/31 17:02
 * @Version:        1.0
 */

public class BeanUtilsTest {

    public static void main(String[] args) {

        Student student = new Student();
        student.setStuId((long)111111);
        //student.setAge(15);
        student.setGender((byte)1);
        Teacher teacher = new Teacher();
        teacher.setTeaId((long)22222222);
        teacher.setAge(18);
        teacher.setGender((byte)2);
         /**
          * @description:BeanUtils.copyProperties(A,B)
          * 将A的属性值赋值给B中对应的属性(A、B中属性的属性类型相同并且属性名相同),以A中属性为基准，
          * 全复制，即使A.K=null&&B.K!=null,copy后-->B.K=null
          * BeanUtils.copyProperties(A,B,String...ignoreProperties)可以指定忽略一个或多个属性不景行Copy
          * 属性可以是公共的或者A/B独有的，亦可以是二者都不包含的属性
          * @author: qhm
          * @date:
          * @Version: 1.0
          */
        //BeanUtils.copyProperties(student,teacher);
        BeanUtils.copyProperties(student,teacher,"teaID");
        System.out.println(student.getStuId()+";"+student.getAge()+";"+student.getGender());
        System.out.println(teacher.getTeaId()+";"+teacher.getAge()+";"+teacher.getGender());


    }
}
