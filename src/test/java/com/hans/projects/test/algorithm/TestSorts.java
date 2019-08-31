package com.hans.projects.test.algorithm;

import com.alibaba.fastjson.JSONObject;
import com.hans.projects.test.algorithm.sorts.HeapSort;
import com.hans.projects.test.algorithm.sorts.SimpleSorts;
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
    @DisplayName("归并排序")
    public void testMergeSort() {
//        arr = MergeSort.mergeSort(arr);
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
        SimpleSorts.quickSort(arr, 0, arr.length-1);
    }
    @Test
    @DisplayName("冒泡排序")
    public void testBubbleSort() {
        SimpleSorts.bubbleSort(arr);
    }

    @Test
    @DisplayName("冒泡排序")
    public void testSelectSort() {
        SimpleSorts.selectSort(arr);
    }


    @Rule
    public TestName name= new TestName();

    @Before
    public void before() throws NoSuchMethodException {
        String discription = this.getClass().getDeclaredMethod(name.getMethodName(),null).getAnnotation(DisplayName.class).value();
        System.out.println("["+name.getMethodName()+"] "+discription);
        System.out.println("["+name.getMethodName()+"] 原始数组 : "+ JSONObject.toJSONString(arr));
    }
    @After
    public void after() {
        System.out.println("["+name.getMethodName()+"] 排序完成 : "+ JSONObject.toJSONString(arr));
    }
}
