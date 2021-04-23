package com.qhm.zk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        //字符长度
        if (i < 3 || i > 7) {
            System.out.println(-1);
        }
        //第x个水仙花数
        int a1 = sc.nextInt();
        int k = 1;
        while (i > 0) {
            k = k * 10;
            i--;
        }
        k = k - 1;
        List<Integer> list = new ArrayList<>();
        for (int j = 100; j <= k; j++) {
            int count = 0;
            char[] s = String.valueOf(j).toCharArray();
            for (int a = 0; a < s.length; a++) {
                int i1 = Integer.parseInt(String.valueOf(s[a]));
                i1 = i1 * i1 * i1;
                count += i1;
            }
            if (count == j) {
                list.add(j);
            }
        }
        if (a1 >= list.size()) {
            Integer integer = list.get(list.size() - 1);
            System.out.println(integer * a1);
        } else {
            System.out.println(list.get(a1));
        }
    }
}*/
/*
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //流水线条数 任务的个数
        String s = br.readLine();
        String[] strs = s.split(" ");
        int lines = Integer.parseInt(strs[0]);
        int tasks = Integer.parseInt(strs[1]);

        String s1 = br.readLine();
        String[] strs2 = s1.split(" ");
        int[] times = new int[strs2.length];
        for (int i = 0; i < times.length; i++) {
            times[i] = Integer.parseInt(strs2[i]);
        }
        //记录排序的
        //int[][] nu = new int[lines][tasks];
        int[] c = new int[lines];
        // 1 2 3 1  2   3  1 2
        //[2,3,4,8,10,11,15,17]
        //排序
        Arrays.sort(times);
        //第x条线完成的时间最短
        int i = tasks % lines;
        int time = 0;
        //算出i条线做的工作即可
        for (int a = 0; a < tasks; a++) {
            if ((a + 1) / lines - i == 0 || (a + 1) == i) {
                time += times[a];
            }
        }
        time += times[times.length - 1];
        System.out.println(time);

        */
/*List<Integer> list = new ArrayList<>();
        //遍历任务
        for (int j = 0; j < times.length; j++) {
            //查找耗时最小的生产线
            int x = 0;
            for (int a = 0; a < lines; a++) {
                for (int b = 0; b < j; b++) {
                    if(nu)
                }
            }

        }*//*


    }
}
*/

/**
 * 堆墙
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        int[] stuk = new int[s1.length];
        for (int i = 0; i < stuk.length; i++) {
            stuk[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(stuk);
        int[] stuk2 = stuk;
        int ceng1 = 1;
        int ceng2 = 0;
        //最大积木
        int max = stuk[stuk.length - 1];

        //第一层为1个积木
        for (int i = 0; i < stuk.length - 1; i++) {
            if (ceng1 < 0) {
                break;
            }
            if (stuk[i] < max) {
                for (int j = 0; j < stuk.length - 1; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (stuk[i] + stuk[j] == max) {
                        ceng1 += 1;
                        stuk[i] = 0;
                        stuk[j] = 0;
                        break;
                    }
                    if (j == stuk.length - 2) {
                        ceng1 = -1;
                        break;
                    }
                }
            } else if (stuk[i] == max) {
                ceng1 += 1;
                stuk[i] = 0;
                continue;
            }

        }
        System.out.println(ceng1);
    }
}