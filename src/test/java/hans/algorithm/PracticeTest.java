package hans.algorithm;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class PracticeTest {
    int[] arr = new int[]{6,1,8,4,9,2,5,3,7};
    @Test
    public void test() {
        int i = 0;
        arr[i++] = arr[7];
        System.out.println(i+"...");
//        Practices.heapSort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }

}

