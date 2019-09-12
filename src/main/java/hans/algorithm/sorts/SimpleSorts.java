package hans.algorithm.sorts;

import com.alibaba.fastjson.JSONObject;
import hans.algorithm.utils.SortUtils;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 排序算法合集-共9种排序
 * 插入类排序算法： 直接插入排序、折半插入排序、*希尔排序
 * 交换类排序算法： 冒泡排序、快速排序
 * 选择类排序算法： 简单选择排序、*树形选择排序、堆排序
 * 分治法排序算法： 归并排序
 */
public class SimpleSorts {

    /**
     * [插入类排序算法 | 折半插入排序]
     * step1.折半查找，当前值应当插入的位置
     *   [1, 2, 3, 4, 5, 6, 8, 9]  *7
     * 0  l        m           h       // l=0;h=7;m=3  >
     *    ----------------------
     * 1              l  m     h       // l=4;h=7;m=5  >
     *                ----------
     * 2                    lm h       // l=6;h=7;m=6  <
     *                      ----
     * 3                    lhm        // l=6;h=6;m=6  <
     *                      -
     * 4                 h  l          // l=6;h=5; l<h 结束
     * 找到了*7要插入的位置，即5-6之间
     * 接下来是移动
     * 从*7开始整体移动，直到6，然后将6替换为*7排序结束
     *
     * 时间复杂度：O(nxn)
     * @param arr
     */
    public static void binInsertSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int tmp = arr[i];
            int high = i-1;
            int low = 0;
            while (low<=high) {
                int mid = (low+high)/2;
                if (tmp<arr[mid]) {
                    high = mid-1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j=i-1; j>high;j--) {
                arr[j+1] = arr[j];
                System.out.println("[move] "+JSONObject.toJSONString(arr));
            }
            arr[low] = tmp;
            System.out.println("[after move] "+JSONObject.toJSONString(arr));
        }
    }

    /**
     * [插入类排序算法 | 直接插入排序]
     * 时间复杂度: O(nxn)
     * 思路
     *          6, 1,8,4,9,2,5,3,7
     * 第一趟:  [6],*1,8,4,9,2,5,3,7  第1个已经有序了，将1插入到[6]中
     * 第二趟:  [1,6],*8,4,9,2,5,3,7  前2个已排好序，固定前2个，将8插入[1,6]中
     * 第三趟:  [1,6,8],*4,9,2,5,3,7  前3个已排好序，固定前3个，将4插入[1,6,8]中
     * 第四趟:  [1,4,6,8],*9,2,5,3,7  前4个已排好序，固定前4个，将9插入[1,6,8]中
     * ...，如此循环下去直到最后一位插入有序数组
     * @param arr
     */
    public static void insertSort(int[] arr) {
        // 第一个元素组成的数组一定是有序的，因此从当前元素从第二个开始，i=1
        for (int i=1; i<arr.length; i++) {
            // 如果当前元素比有序数组的最大值小，则需要将当前元素插入数组；因为数组是有序的所以只需要和数组的最后一个值比较即可即arr[i-1]，
            // 如果当前元素比i-1还大，不需要插入，继续遍历，把当前元素放在数组末尾即可
            if (arr[i]<arr[i-1]) {
                // 执行插入时，整体向后移动一位
                int tmp = arr[i];
                arr[i] = arr[i-1];
                int j=i-1;
                // 直到发现比当前值小的位置，停止移动
                for (; j>0&&arr[j-1]>tmp; j--) {
                    arr[j] = arr[j-1];
                }
                // 将当前值，插入到合适的位置
                arr[j] = tmp;
                System.out.println("[insert Sort] "+JSONObject.toJSONString(arr));
            }
        }
    }

    /**
     * [交换类排序算法 | 冒泡排序]
     * 冒泡排序；时间复杂度O(nxn)
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
     * [交换类排序算法 | 快速排序]
     * 时间复杂度: O(nlogn)
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
    private static void quick(int[] arr, int low, int high) {
        if (low >= high) return;
        int l = low;
        int h = high;
        int pivot = arr[low];

        while (l < h) {
            while (l<h && arr[h]>pivot) h--;
            arr[l] = arr[h];
            while (l<h && arr[l]<pivot) l++;
            arr[h] = arr[l];
            System.out.println("[quick sort] low="+low + "; high=" +high+"; pivot = " + pivot + JSONObject.toJSONString(arr));
        }

        // 这里角标用h或l都可以，此时h==l
        arr[h] = pivot;
        System.out.println("[quick sort] low="+low + "; high=" +high+"; pivot = " + pivot + JSONObject.toJSONString(arr));
        quick(arr, low, h-1);
        quick(arr, h+1, high);
    }


    /**
     * [选择类排序算法 | 简单选择排序]
     * 时间复杂度: O(nxn)
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

    /**
     * 分治法
     * 归并排序
     * 时间复杂度：O(nlogn)
     * 归并排序需要建立临时数组因此对空间有一定浪费
     *
     * 思路：
     * 1.通过递归将数组进行切分
     * index:     0  1  2  3  4  5  6  7  8
     * array:     1, 6, 8, 4, 9, 2, 5, 3, 7
     *            -------------  ==========
     *            -------  ====  ----  ====
     *            ----  =  =  =  =  =  =  =
     * 2.将拆分后的数组两两合并，核心也是在合并的算法上
     *   1.使用临时数组，对两两合并的数组重新排序
     *
     *
     */
    public static void mergeSort(int[] arr) {
        divide(arr, 0, arr.length-1);
    }

    private static void divide(int[] arr, int low, int high) {
        if (low>=high) return;

        System.out.println("[divide] left=["+JSONObject.toJSONString(arr).substring((low)*2+1,((low+high)/2+1)*2)+"]"
                + " right=["+JSONObject.toJSONString(arr).substring(((low+high)/2+1)*2+1,high*2+2)+"]");

        divide(arr, low, (low+high)/2);
        divide(arr,(low+high)/2+1, high);
        merge(arr,low,(low+high)/2, high);
    }

    /**
     * 合并数组，将左右两个有序数组进行合并：left: low->mid; right: mid+1->high
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int[] arr, int low, int mid, int high) {
        // 仅用于日志，不影响算法
        String leftAndRight = " left=["+JSONObject.toJSONString(arr).substring((low)*2+1,(mid+1)*2)+"]"
                + " right=["+JSONObject.toJSONString(arr).substring((mid+1)*2+1,high*2+2)+"] ";

        int[] tmp = new int[high-low+1];
        int left = low; // left数组的起始位置
        int right = mid+1; // right数组的其实位置

        int index = 0; // 临时数组游标
        // left数组：left->mid; right数组：right->high
        while (left<=mid && right<=high) {
            // 合并left和right两个数组，把它们放在临时数组中
            if (arr[left]<arr[right]) {
                tmp[index++] = arr[left++];
            } else {
                tmp[index++] = arr[right++];
            }
        }
        // 合并后，如果left还有剩余，将剩下的元素也放入临时数组
        while (left<=mid) {
            tmp[index++] = arr[left++];
        }
        // 合并后，如果right还有剩余，将剩下的元素也放入临时数组
        while (right<=high) {
            tmp[index++] = arr[right++];
        }
        // 最后覆盖原始数组，low->high位置的元素，此时已经排好序了
        for (int i=0; i<=high-low; i++) {
            arr[low+i] = tmp[i];
        }
        System.out.println("[merge] "+JSONObject.toJSONString(arr) + leftAndRight);
    }



}
































