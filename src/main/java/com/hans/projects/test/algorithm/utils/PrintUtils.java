package com.hans.projects.test.algorithm.utils;

public class PrintUtils {


    public static void printTree(int[] arr) {
        int d = treeDepth(arr, 0);
        int count = 2;
        System.out.println(arr[0]);
        int index = 1;
        for (int i=0; i<d-1; i++) {
            for (int j=0; j<count&&index<arr.length; j++) {
                System.out.print(arr[index]+" ");
                index++;
            }
            count*=2;
            System.out.println();
        }
    }
    public static int treeDepth(int[] arr, int d) {
        if (2*d+1<arr.length) {
            d++;
            return treeDepth(arr, d);
        }
        return d;
    }
}
