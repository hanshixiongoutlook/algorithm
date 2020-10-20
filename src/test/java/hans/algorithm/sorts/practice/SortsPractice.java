package hans.algorithm.sorts.practice;

import com.alibaba.fastjson.JSONObject;
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
public class SortsPractice {
    int[] arr = new int[]{6,1,8,4,9,2,5,3,7};


    @Test
    @DisplayName("1.冒泡排序")
    public void testBubbleSort(){
    }
    @Test
    @DisplayName("2.选择排序")
    public void testSelectSort() {
    }
    @Test
    @DisplayName("3.快速排序")
    public void testQuickSort() {
    }
    @Test
    @DisplayName("4.堆排序：大顶堆")
    public void testMaxHeapSort() {
    }
    @Test
    @DisplayName("4.堆排序：小顶堆")
    public void testMinHeapSort() {
    }
    @Test
    @DisplayName("5.归并排序")
    public void testMergeSort() {
    }
    @Test
    @DisplayName("6.插入排序")
    public void testInsertSort() {
    }
    @Test
    @DisplayName("7.折半插入排序")
    public void testBinInsertSort() {
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
