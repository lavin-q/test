package com.qhm.example.test.xunhuan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* @Description: for 循环测试<br/>
* @Author: qhm <br/>
* @Date: 2019/10/12 14:32<br/>
* @Version: 1.0 <br/>
*/

public class TestXunHuan {

    public static void main(String[] args) {
        Random random = new Random();

        String v = String.valueOf(random.nextFloat());
        String substring = v.substring(2, 7);
        System.out.println(substring);

        List<String> list = new ArrayList<>();
        list.add("55454545");
        list.add("65535");
        String a = "655356";
        boolean contains = list.contains(a);
        System.out.println(contains);
    }
}
