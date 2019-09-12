package hans.algorithm;

import com.alibaba.fastjson.JSONObject;
import hans.algorithm.utils.PrintUtils;
import hans.algorithm.utils.SortUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.TestName;

/**
 * 排序算法合集-共9种排序
 * 插入类排序算法： 直接插入排序、折半插入排序、*希尔排序
 * 交换类排序算法： 冒泡排序、快速排序
 * 选择类排序算法： 简单选择排序、*树形选择排序、堆排序
 * 分治法排序算法： 归并排序
 */
public class SortsPracticeDay1 {
    int[] arr = new int[]{6,1,8,4,9,2,5,3,7};


    @Test
    @DisplayName("1.冒泡排序")
    public void testBubbleSort(){
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                if (arr[j]<arr[i]) {
                    SortUtils.swap(arr, i, j);
                }
            }
        }
    }
    @Test
    @DisplayName("2.选择排序")
    public void testSelectSort() {
        for (int i=0; i<arr.length; i++) {
            int min = i;
            for (int j=i; j<arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min!=i) SortUtils.swap(arr, i, min);
        }
    }
    @Test
    @DisplayName("3.快速排序")
    public void testQuickSort() {
        quick(arr, 0, arr.length-1);
    }

    private void quick(int[] arr, int low, int high) {
        if (low >= high) return;
        int l = low;
        int h = high;
        int pivot = arr[low];

        while (l<h) {
            while (l<h&&arr[h]>pivot) h--;
            arr[l] = arr[h];
            while (l<h&&arr[l]<pivot) l++;
            arr[h] = arr[l];
        }
        arr[l] = pivot;
        quick(arr, low, l-1);
        quick(arr, l+1, high);

    }

    @Test
    @DisplayName("4.堆排序")
    public void testMaxHeapSort() {
        buildHeap(arr);
        System.out.println("排序过程：------");
        for (int i=arr.length-1; i>0; i--) {
            SortUtils.swap(arr, i, 0);
            heap(arr, 0, i);
        }
    }

    private void buildHeap(int[] arr) {
        for (int i=arr.length/2; i>=0; i--) {
            heap(arr, i, arr.length);
        }
        PrintUtils.printTree(arr);
    }
    private void heap(int[] arr, int root, int high) {
        System.out.println("root = "+root+"; high = "+high+"：------");
        PrintUtils.printTree(arr);
        int left = root*2+1;
        int right = root*2+2;
        int min = root;

        if (left<high&&arr[min]>arr[left]) min = left;
        if (right<high&&arr[min]>arr[right]) {
            min = right;
        }

        if (min!=root) {
            SortUtils.swap(arr, root, min);
            heap(arr, min, high);
        }
    }

    @Test
    @DisplayName("5.归并排序")
    public void testMergeSort() {
        divide(arr, 0, arr.length-1);
    }

    private void divide(int[] arr, int low, int high) {
        if (low>=high) return;

        divide(arr, low, (low+high)/2);
        divide(arr, (low+high)/2+1, high);
        merge(arr,low,(low+high)/2, high);

    }

    private void merge(int[] arr, int low, int mid, int high) {

        int[] tmp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while (left<=mid&&right<=high) {
            if (arr[left]<arr[right]) tmp[index++] = arr[left++];
            else tmp[index++] = arr[right++];
        }
        while (left<=mid) tmp[index++] = arr[left++];
        while (right<=high) tmp[index++] = arr[right++];

        for (int i=0; i<tmp.length; i++) {
            arr[low+i] = tmp[i];
        }
    }

    @Test
    @DisplayName("6.插入排序")
    public void testInsertSort() {
        for (int i=1; i<arr.length; i++) {
            if (arr[i]<arr[i-1]) {
                int tmp = arr[i];
                arr[i] = arr[i-1];
                int j=i-1;
                for (; j>0&&tmp<arr[j-1]; j--) {
                    arr[j] = arr[j-1];
                }
                arr[j] = tmp;
            }

        }
    }
    @Test
    @DisplayName("7.折半插入排序")
    public void testBinInsertSort() {
        for (int i=1; i<arr.length; i++) {
            int tmp = arr[i];
            int high = i-1;
            int low = 0;
            while (low<=high) {
                int mid = (low+high)/2;
                if (arr[mid]<tmp) low = mid+1;
                else high = mid-1;
            }
            for (int j=i-1;j>high;j--) {
                arr[j+1] = arr[j];
            }
            arr[low] = tmp;
        }

    }
    @Test
    @DisplayName("8.希尔排序")
    public void testShellSort() {
    }
    @Test
    @DisplayName("9.树形选择排序")
    public void testTreeSelectSort() {
    }

























    @Rule
    public TestName name= new TestName();

    @Before
    public void before() throws NoSuchMethodException {
        String discription = this.getClass().getDeclaredMethod(name.getMethodName()).getAnnotation(DisplayName.class).value();
        System.out.println("["+name.getMethodName()+"] "+discription + " : " + JSONObject.toJSONString(arr));
    }
    @After
    public void after() {
        System.out.println("["+name.getMethodName()+"] 排序完成 : "+ JSONObject.toJSONString(arr));
    }
}
