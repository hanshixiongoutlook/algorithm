package hans.algorithm.sorts.demo;

import com.alibaba.fastjson.JSONObject;
import hans.algorithm.utils.Logger;
import org.junit.Test;

public class Recurisive {

	int[] arr;

	@Test
	public void testKString() {
		int num = 2;
		arr = new int[num];
		kString(num, 3);
	}
	public void kString(int n, int k) {
		if (n<1) {
			Logger.log(JSONObject.toJSONString(arr));
		} else {
			for (int j=0; j<k; j++) {
				arr[n-1]=j;
				kString(n-1, k);
			}
		}
	}

	@Test
	public void testRecall() {
		int num = 0;
		arr = new int[num];
		recall(num,0);
	}
	public void recall(int n, int count) {
		if (n<1) {
			Logger.log("{}",JSONObject.toJSONString(arr));
		} else {
			arr[n-1] = 0;
			recall(n-1, count++);
			arr[n-1] = 1;
			recall(n-1, count++);
		}
	}
}
