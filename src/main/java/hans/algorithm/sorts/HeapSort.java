package hans.algorithm.sorts;

import hans.common.utils.Logger;
import hans.common.utils.PrintUtils;
import hans.common.utils.SortUtils;

/**
 * 选择类
 * 堆排序；时间复杂度 O(n*logn)
 * 数据较少时，没有必要使用堆排序，需要花费时间来初始化堆
 */
public abstract class  HeapSort {
    public enum SortType {
        /*从小到大排序*/
        ASC,
        /**从大到小排序
         */
        DESC;
    }
    public static HeapSort getInstance(SortType type) {
        if (type.equals(SortType.ASC)) return new MaxHeapSort();
        else return new MinHeapSort();
    }

    /**
     * 对arr进行排序，排序方式取决于选择的SortType
     * TO_MAX使用大顶堆，TO_MIN使用小顶堆
     * @param arr
     */
    public final void sort(int[] arr) {
        Logger.log("建堆过程：------");
        buildHeap(arr);
        Logger.log("初始堆-构建完成：------");
        PrintUtils.printTree(arr);
        Logger.log("排序过程：------");
        for (int i=arr.length - 1; i>0; i--) {
            SortUtils.swap(arr, 0, i);
            heap(arr, 0, i);
        }
    }

    /**
     * 将arr构造成堆
     * TO_MAX使用大顶堆，TO_MIN使用小顶堆
     * @param arr
     */
    protected final void buildHeap(int[] arr) {
        for (int i=arr.length/2; i>=0; i--) {
            heap(arr, i, arr.length);
        }
    }

    /**
     * 堆的局部构造
     * @param arr
     * @param root 堆构造的根节点
     * @param high 对构造的最大节点
     */
    abstract void heap(int[] arr, int root, int high);

}

/**
 * 大顶堆，从小到大排
 */
class MaxHeapSort extends HeapSort {
    @Override
    public void heap(int[] arr, int root, int high) {
        int left = 2*root+1;
        int right = 2*root+2;
        int maxEle = root;
        if (left<high && arr[maxEle] < arr[left]) {
            maxEle = left;
        }
        if (right<high && arr[maxEle] <arr[right]) {
            maxEle = right;
        }
        if (maxEle!=root) {
            SortUtils.swap(arr, maxEle, root);
            heap(arr, maxEle,high);
        }
    }
}

/**
 * 小顶堆，从大到小排
 */
class MinHeapSort extends HeapSort {
    @Override
    public void heap(int[] arr, int root, int high) {
        Logger.log("root = {}; high = {}", root, high);
        PrintUtils.printTree(arr);
        int left = 2*root+1;
        int right = 2*root+2;
        int min = root;
        // 和左孩子比较并交换
        if (left<high && arr[root]>arr[left]) {
            min = left;
        }
        // 和右孩子比较并交换
        if (right<high && arr[min]>arr[right] ) {
            min = right;
        }
        if ( min !=root ) {
            SortUtils.swap(arr, root, min);
            heap(arr, min, high);
        }
    }
}




