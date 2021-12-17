package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_1646_GetMaximumInGeneratedArray {
    @Test
    public void test() {
        int num = getMaximumGenerated(3);
        Logger.log(num);
    }


    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.1 MB, less than 71.64% of Java online submissions.
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     *
     * @param n
     * @return
     */
    public int getMaximumGenerated(int n) {
        if (n<=1) {
            return n;
        }
        int max = 1;
        int[] arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i=2; i<=n; i++) {
            int val = arr[i/2];
            if (i%2!=0) {
                val = arr[i/2]+arr[i/2+1];
            }
            arr[i] = val;
            max = Math.max(val, max);
        }
        return max;

    }

}
