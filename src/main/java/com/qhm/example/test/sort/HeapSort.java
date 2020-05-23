package com.qhm.example.test.sort;

import java.util.Arrays;

/**
 * @Description : 从小到大堆排序  //描述
 * @Author : qhm  //作者
 * @Date: 2020-05-23 15:44  //时间
 */
public class HeapSort {

    /**
     * 1.堆排序的过程就时构建一个完全二叉树
     */


    //给定数组从小到大排序
    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 8, 5, 7, 4, 10, 50, 100, 1, 0, 0};
        int[] ints = heapConstract(arr);
        int size = arr.length;
        while (size > 1) {
            //固定最大值
            swap(arr, 0, size - 1);
            size--;
            //构造大根堆
            heapify(arr, 0, size);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 构建大根堆结构-->根节点的元素大于左右子节点的元素
     *
     * @param arr
     */
    public static int[] heapConstract(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //判断当前插入的元素下标
            int currentIndex = i;
            if (currentIndex != 0) {
                //获取父节点的元素下标
                int fatherIndex = (currentIndex - 1) / 2;
                //每次插入新元素时保证顶端元素时最大的
                //如果新插入子节点的值大于父节点的值,二者交换，并将当前索引指向父节点
                //交换后继续向上递归，保证大根堆结构完整
                while (arr[currentIndex] > arr[fatherIndex]) {
                    //新插入子节点的值大于父节点的值,二者交换
                    swap(arr, currentIndex, fatherIndex);
                    //将当前索引指向父节点
                    currentIndex = fatherIndex;
                    //重新计算父节点的index
                    fatherIndex = (currentIndex - 1) / 2;
                }
            }

        }
        return arr;
    }

    /**
     * @param arr   大根堆数组
     * @param index 数组下标·
     * @param size  数组长度
     */
    public static void heapify(int[] arr, int index, int size) {
        //左子节点index
        int left = index * 2 + 1;
        //右子节点
        int right = index * 2 + 2;

        //判断左子节点index在数组范围内
        while (left < size) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (right < size && arr[left] < arr[right]) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }

            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }

            //父节点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;

        }
    }


    /**
     * 元素交换
     *
     * @param arr 数组
     * @param i   数组下标
     * @param j   数组下标
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
