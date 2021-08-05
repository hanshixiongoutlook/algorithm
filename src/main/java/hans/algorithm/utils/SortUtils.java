package hans.algorithm.utils;

public class SortUtils {
    public static int[] ARRAY = new int[]{5,3,1,6,9,4,8,5,7};

    /**
     * 交换arr中第i位和第j位两个数的位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
