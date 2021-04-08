package com.qhm.collection;

/*
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description :  华为机试 //描述
 * @Author : qhm  //作者
 * @Date: 2021-04-07 18:14  //时间
 * <p>
 * 计算字符个数
 * <p>
 * 计算字符个数
 * <p>
 * 计算字符个数
 * <p>
 * 计算字符个数
 * <p>
 * 计算字符个数
 * <p>
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * <p>
 * 计算字符个数
 * <p>
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * <p>
 * 质数因子
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 最后一个数后面也要有空格
 * <p>
 * 取近似值
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 */

/*//明明喝饮料
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("0")) {
            int n = sc.nextInt();
            int count = 0;
            while (n / 3 > 0) {
                count += n / 3;
                n = n / 3 + n % 3;
                if (n == 2) {
                    n = n + 1;
                }
            }
            System.out.println(count);
        }
    }
}*/


//输入1000个的数字排序输出
/*public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] target = new int[1000];

        while (scan.hasNextInt()) {
            for (int i = 0; i < 1000; i++) {
                target[i] = 0;
            }

            int num = scan.nextInt();
            for (int i = 0; i < num; i++) {
                int next = scan.nextInt();
                target[next] = next;

            }
            for (int i = 0; i < 1000; i++) {
                if (target[i] == 0) {

                } else {
                    System.out.println(target[i]);
                }
            }
        }
    }
}*/

//进制转换
/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String s = scanner.next();

            System.out.println(Integer.decode(s));

        }

    }

}*/


//计算字符串最后一个单词的长度，单词以空格隔开。
/*public class Main {
    public static void main(String[] args) throws IOException {
        int length = 0;
        InputStream in = System.in;
        char c = (char) in.read();
        while (c != '\n') {
            if (c == ' ') {
                length = 0;
            } else {
                length += 1;
            }
            c = (char) in.read();
        }
        System.out.println(length);
    }
}*/

/**
 * 计算字符个数
 */
/*public class Main {
    public static void main(String[] args) throws IOException {
        *//*Map<Character, Integer> map = new HashMap<>();
        InputStream in = System.in;
        char c = (char) in.read();
        while (c != '\n') {
            map.merge(Character.toUpperCase(c), 1, Integer::sum);
            c = (char) in.read();
        }
        c = (char) in.read();
        Integer a = map.get(Character.toUpperCase(c));
        System.out.println(a == null ? 0 : a);*//*

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = br.readLine().toLowerCase().toCharArray();
        char[] chars2 = br.readLine().toLowerCase().toCharArray();
        int count = 0;
        for (char c : chars1) {
            if (c == chars2[0]) {
                count++;
            }
        }
        System.out.println(count);

    }
}*/

/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *  可以逐行输出
 */
/*public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            //不为空时
            int len = str.length();
            int start = 0;
            while (len > 8) {
                System.out.println(str.substring(start, start + 8));
                start += 8;
                len -= 8;
            }
            if (len > 0) {
                char[] temp = new char[8];
                for (int i = 0; i < 8; i++) {
                    temp[i] = '0';
                }
                for (int i = 0; start < str.length(); i++) {
                    temp[i] = str.charAt(start++);
                }
                System.out.println(String.valueOf(temp));
            }
        }
    }
}*/

/**
 * 质数因子
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 */
/*public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    sb.append(i).append(" ");
                    num = num / i;
                    i--;
                }
            }
            sb.append(num).append(" ");
            System.out.println(sb.toString());
        }
    }
}*/

/**
 * 取近似值
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 */
/*public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        float v = sc.nextFloat();
        int round = Math.round(v);
        System.out.println(round);

    }
}*/

/**
 * 合并表记录
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 索引的大小不会超过给定的行数大小，所以可以用数组下表来判断
 */
/*public class Main {
    public static void main(String[] args) throws IOException {
        //输入值
       *//* Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();*//*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        //Map<Integer, Integer> map = new HashMap<>();
        line = br.readLine();
        int[] ints = new int[Integer.parseInt(line)];
        while ((line = br.readLine())!=null){
            int a = line.indexOf(" ");
            int b = line.indexOf(" ", a);
            int c = Integer.parseInt(line.substring(0, a));
            int d = Integer.parseInt(line.substring(a + 1));
            ints[c] = ints[c]+d;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <ints.length ; i++) {
            if (ints[i]!=0){
                sb.append(i).append(" ").append(ints[i]).append("\n");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());


    }
}*/

