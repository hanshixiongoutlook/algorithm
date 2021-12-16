package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_0053_MaximumSubarray {
    @Test
    public void test() {
        int num = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        Logger.log(num);
    }

    /**
     *			Runtime:1 ms, faster than 98.13% of Java online submissions.
     * 			Memory Usage:48.8 MB, less than 10.50% of Java online submissions.
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre=0;
        int max=nums[0];
        for (int n: nums) {
            pre = Math.max(pre+n, n);
            max = Math.max(max, pre);
        }
        return max;
    }

}
