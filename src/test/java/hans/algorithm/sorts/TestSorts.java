package hans.algorithm.sorts;

import com.alibaba.fastjson.JSONObject;
import hans.algorithm.sorts.HeapSort;
import hans.algorithm.sorts.ShellSort;
import hans.algorithm.sorts.SimpleSorts;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.TestName;

/**
 * 测试各种排序
 *
 * 排序算法合集-共9种排序
 * 插入类排序算法： 直接插入排序、折半插入排序、*希尔排序
 * 交换类排序算法： 冒泡排序、快速排序
 * 选择类排序算法： 简单选择排序、*树形选择排序、堆排序
 * 分治法排序算法： 归并排序
 */
public class TestSorts {
    int[] arr = new int[]{1,6,8,4,9,2,5,3,7};

    @Test
    @DisplayName("希尔排序")
    public void testShellSort() {
        ShellSort.shellSort(arr);
    }
    @Test
    @DisplayName("折半插入排序")
    public void testBinInsertSort() {
        SimpleSorts.binInsertSort(arr);
    }
    @Test
    @DisplayName("插入排序")
    public void testInsertSort() {
        SimpleSorts.insertSort(arr);
    }
    @Test
    @DisplayName("归并排序")
    public void testMergeSort() {
        SimpleSorts.mergeSort(arr);
    }
    @Test
    @DisplayName("堆排序：大顶堆")
    public void testMaxHeapSort() {
        HeapSort.getInstance(HeapSort.SortType.ASC).sort(arr);
    }
    @Test
    @DisplayName("堆排序：小顶堆")
    public void testMinHeapSort() {
        HeapSort.getInstance(HeapSort.SortType.DESC).sort(arr);
    }

    @Test
    @DisplayName("快速排序")
    public void testQuickSort() {
        SimpleSorts.quickSort(arr);
    }
    @Test
    @DisplayName("冒泡排序")
    public void testBubbleSort() {
        SimpleSorts.bubbleSort(arr);
    }

    @Test
    @DisplayName("选择排序")
    public void testSelectSort() {
        SimpleSorts.selectSort(arr);
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
