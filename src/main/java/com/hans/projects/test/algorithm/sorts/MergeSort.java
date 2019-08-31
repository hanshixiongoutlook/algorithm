package com.hans.projects.test.algorithm.sorts;

import com.alibaba.fastjson.JSONObject;

/**
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        divide(arr, 0, arr.length-1);
    }

    public static void divide(int[] arr, int low, int high) {

        if (low>=high) return;

        divide(arr, low, (low+high)/2);
        divide(arr,(low+high)/2+1, high);
        merge(arr,low,(low+high)/2, high);
    }
    public static void merge(int[] arr, int low, int mid, int high) {

        System.out.println("[merge] left_arr=["+JSONObject.toJSONString(arr).substring((low)*2+1,(mid+1)*2)+"]"
                        + " right_arr=["+JSONObject.toJSONString(arr).substring((mid+1)*2+1,high*2+2)+"]");
        int[] tmp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while (left<=mid && right<=high) {
            if (arr[left]<arr[right]) {
                tmp[index++] = arr[left++];
            } else {
                tmp[index++] = arr[right++];
            }
        }
        while (left<=mid) {
            tmp[index++] = arr[left++];
        }
        while (right<=high) {
            tmp[index++] = arr[right++];
        }
        for (int i=0; i<=high-low; i++) {
            arr[low+i] = tmp[i];
        }
        System.out.println(JSONObject.toJSONString(arr));
    }

}
