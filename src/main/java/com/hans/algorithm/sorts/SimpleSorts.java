package com.hans.algorithm.sorts;

import com.alibaba.fastjson.JSONObject;
import com.hans.algorithm.utils.SortUtils;

/**
 * 简单排序算法合集：冒泡排序、选择排序、快速排序
 */
public class SimpleSorts {


    /**
     * 交换类
     * 冒泡排序；时间复杂度O(n*n)
     * 思路：以从小到大顺序为例
     * 比较相邻两个元素，如果arr[i]>arr[i+1]，则交换
     * 这样，
     * 第一趟，把最大值放到了最后一位
     * 第二趟，把第二大值放在倒数第二位
     * ...
     * 依次进行指导第n-1趟完成排序
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j< arr.length-1-i; j++) {
                if (arr[j]> arr[j+1]) {
                    SortUtils.swap(arr,j,j+1);
                    System.out.println("[Bubble Sort] " + JSONObject.toJSONString(arr));
                }
            }
        }
    }

    /**
     * 交换类
     * 快速排序；时间复杂度O(n*logn)
     * 思路：
     * 3,2,6,1,7,4,5
     * 先找基准值pivot，一般使用最低位的值，如第一趟采用的是index=0位上的值
     * 第一趟，以pivot为基准，>pivot的值放在右边；<pivot的值放在左边，再pivot放在中间位置上
     * 1,2,[3],6,7,4,5
     * --这里，如果是单数个则放在中间位置，如果是双数个，则放在临近的一侧
     * 第一趟结束，递归开始
     * 先从左侧开始，
     * 左侧第一趟，传入arr，low=0，high=中间位的index
     * 左侧第二趟，递归如果还没有结束，则继续传入，arr，low=0，high=新的中间位index
     * 如此直到全部左侧排序完成，所有中间位都归位
     * 开始右侧排序
     * 右侧第一趟，和左侧顺序正好相反，low=
     * 1,2,3 左|右 6,7,4,5

     * @param arr
     */
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }
    public static void quick(int[] arr, int low, int high) {
        if (low >= high) return;
        int l = low;
        int h = high;
        int pivot = arr[low];

        while (l < h) {
            while (l<h && arr[h]>pivot) h--;
            arr[l] = arr[h];
            while (l<h && arr[l]<pivot) l++;
            arr[h] = arr[l];
        }

        // 这里角标用h或l都可以，此时h==l
        arr[h] = pivot;
        System.out.println("[quick sort] low="+low + "; high=" +high+"; pivot = " + pivot + JSONObject.toJSONString(arr));
        quick(arr, low, h-1);
        quick(arr, h+1, high);
    }


    /**
     * 选择类
     * 选择排序；时间复杂度 O(n*n)
     * 思路：
     * 第一趟，找出最小的值，放在0位
     * 第二趟，在1-max之间找到最小值，放在1位
     * ...
     * 直到n-1趟，完成排序
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i< arr.length; i++) {
            int min = i;
            for (int j = i+1; j< arr.length; j++) {
                if (arr[j]< arr[min]) {
                    min=j;
                }
            }
            SortUtils.swap(arr,min,i);
            System.out.println("[Select Sort] min_index=" + min + JSONObject.toJSONString(arr));
        }
    }


    public static void insertSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            if (arr[i]<arr[i-1]) {
                int tmp = arr[i];
                arr[i] = arr[i-1];
                int j = i-2;
                for (;j>=0&&arr[j]>tmp;j--) {
                    arr[j+1] = arr[j];
                }
                arr[j+1] = tmp;
            }
            System.out.println("[insert Sort] "+JSONObject.toJSONString(arr));
        }
    }


}
































