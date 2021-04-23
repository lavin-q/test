package com.qhm.collection;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Object[] commonSuffix = findCommonSuffix(null);
    }

    public static Object[] findCommonSuffix(String[] str) {
        //获取第一个str
        //1和2比较出来的字串和3比较
        /*StringBuilder sb = new StringBuilder("");
        StringBuilder temp = new StringBuilder("");
        char[] chars1;
        char[] chars2;
        for (int i = 1; i < str.length; i++) {
            chars1 = new StringBuilder(str[i]).reverse().toString().toCharArray();
            if (i == 1) {
                chars2 = new StringBuilder(str[i - 1]).reverse().toString().toCharArray();
            } else {
                chars2 = sb.reverse().toString().toCharArray();
            }
            for (int j = 0; j < (chars1.length > chars2.length ? chars2.length : chars1.length); j++) {
                if(chars1[j] == chars2[i]){
                    temp.append(chars1[i]);
                }
            }
            sb = temp;
        }
        return sb.reverse().toString();*/
        Integer[] a1 = new Integer[]{1,2,2,4};
        //int[] a = new int[]{1,2,2,4};
       /* a1[0] = 1;
        a1[1] = 2;
        a1[2] = 2;
        a1[3] = 3;*/
        Integer[] a2 = new Integer[]{2,2};
        /*a2[0] = 2;
        a2[1] = 2;*/
        Integer[] a3 = new Integer[a1.length];
        //int a4[] = new int[a1.length];
        for (int k = 0; k < a3.length; k++) {
            a3[k] = null;
        }
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] != null && a2[j] != null  &&a1[i] == a2[j] ) {
                    a3[i] = a1[i];
                    a1[i] = null;
                    a2[j] = null;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k < a3.length; k++) {
            if (a3[k] != null) {
                list.add(a3[k]);
            }
        }


        Object[] objects = list.toArray();
        return list.toArray();
    }
}
