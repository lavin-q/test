package com.qhm.example.test.sort;

import java.util.Arrays;

/**
 * @Description : 从大到小堆排序实现  //描述
 * @Author : qhm  //作者
 * @Date: 2020-05-23 16:42  //时间
 */
public class SelfHeapSort {

    //给定数组从大到小排序
    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 8, 5, 7, 4, 10, 50, 100, 1, 0, 0};
        heapConstract(arr);
        int size = arr.length;
        while (size > 1) {
            swap(arr, 0, size - 1);
            size--;
            heapify(arr, 0, size);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 构建小根堆
     */
    public static void heapConstract(int[] arr) {
        //循环遍历数组元素
        for (int i = 0; i < arr.length; i++) {
            //获取当前元素数组下标
            int currentIndex = i;
            //获取父节点数组下标
            int fatherIndex = (currentIndex - 1) / 2;
            if (currentIndex != 0) {
                //如果子节点比父节点小,
                while (arr[currentIndex] < arr[fatherIndex]) {
                    swap(arr, currentIndex, fatherIndex);
                    currentIndex = fatherIndex;
                    fatherIndex = (currentIndex - 1) / 2;
                }
            }
        }
    }

    /**
     * 剩余元素构建小根堆
     *
     * @param arr
     * @param index
     * @param size
     */
    public static void heapify(int[] arr, int index, int size) {
        //index 的 左右子节点
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        //判断左右子节点是否在当前大小内
        while (left < size) {
            int smallIndex;
            //寻找子节点最小值的数组下标
            if (right < size && arr[left] > arr[right]) {
                smallIndex = right;
            } else {
                smallIndex = left;
            }
            if (arr[smallIndex] > arr[index]) {
                smallIndex = index;
            }
            if (smallIndex == index) {
                //跳出循环
                break;
            }
            //交换
            swap(arr, index, smallIndex);
            index = smallIndex;
            left = index * 2 + 1;
            right = index * 2 + 1;
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
