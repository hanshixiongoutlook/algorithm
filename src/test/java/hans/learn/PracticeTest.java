package hans.learn;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PracticeTest {
    int[] arr = new int[]{6,1,8,4,9,2,5,3,7};
    @Test
    public void test() throws InterruptedException {
        String str = "";
        Thread.sleep(5000);
        List list = new ArrayList<>();
        for (int i=0;;i++) {
            str+=i;
            list.add(str);
        }

    }


}

