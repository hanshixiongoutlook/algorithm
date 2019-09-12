package hans.algorithm.sorts;

import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int gap = 1;
        while (gap <arr.length) {
            gap = gap*3 + 1;
        }
        while (gap>0) {
            for (int i=gap; i<arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j>=0 && arr[j]>tmp) {
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = tmp;
            }
            gap = (int) Math.floor(gap/3);
        }
    }

}
