package hans.common.utils;

public class PrintUtils {


    /**
     * 将数组按照树形结构打印
     * @param arr
     */
    public static void printTree(int[] arr) {
        int d = treeDepth(arr, 0);
        int count = 2;
        System.out.println(arr[0]);
        int index = 1;
        for (int i=0; i<d-1; i++) {
            for (int j=0; j<count&&index<arr.length; j++) {
                Logger.log(arr[index]+" ");
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
