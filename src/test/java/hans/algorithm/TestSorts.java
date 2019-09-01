package hans.algorithm;

import com.alibaba.fastjson.JSONObject;
import hans.algorithm.sorts.MergeSort;
import hans.algorithm.sorts.SimpleSorts;
import hans.algorithm.sorts.HeapSort;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.TestName;

/**
 * 测试各种排序
 */
public class TestSorts {
    int[] arr = new int[]{6,1,8,4,9,2,5,3,7};
    @Test
    @DisplayName("插入排序")
    public void test() {
        int[] arr = new int[]{6,1,8,4,9,2,5,3,7};
        SimpleSorts.insertSort(arr);
    }
    @Test
    @DisplayName("归并排序")
    public void testMergeSort() {
        MergeSort.mergeSort(arr);
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
