package hans.algorithm.sorts.practice;

import com.alibaba.fastjson.JSONObject;
import hans.algorithm.utils.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.TestName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 排序算法合集-共9种排序
 * 插入类排序算法： 直接插入排序、折半插入排序、*希尔排序
 * 交换类排序算法： 冒泡排序、快速排序
 * 选择类排序算法： 简单选择排序、*树形选择排序、堆排序
 * 分治法排序算法： 归并排序
 */
public class SortsPracticeDay1 {
    int[] arr = new int[]{6,1,8,4,9,2,5,3,7};


    class Dog{
        String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    @Test
    @DisplayName("1.冒泡排序")
    public void testDate() throws ParseException {
        Dog aDog = new Dog("Kick");
        Dog oldD = aDog;
        change(aDog);
        System.out.println(aDog.getName().equals("Kick"));
        System.out.println(aDog.getName().equals("Lily"));
        System.out.println(oldD==aDog);
    }

    private void change(Dog d) {
        d.getName().equals("Kick");
        d = new Dog("Lily");

    }
    @Test
    @DisplayName("1.冒泡排序")
    public void testBubbleSort(){
        for (int i=0; i<arr.length; i++) {
            for (int j=0;j<arr.length-i-1;j++) {
                if (arr[j]>arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        Logger.log(JSONObject.toJSONString(arr));
    }
    @Test
    @DisplayName("2.选择排序")
    public void testSelectSort() {
        for (int i=0; i<arr.length; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j]<arr[minIndex]) {
                    minIndex = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = t;
        }
        Logger.log(JSONObject.toJSONString(arr));
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
