package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_LCCI1716Masseuse {
    @Test
    public void test() {
        int num = massage(new int[]{1, 10, 3, 5, 7});
        Logger.log(num);
    }

    /**
     * f(n) = arr[n] n=0
     * f(n) = Max(arr[0],arr[1]) n=1
     * f(n) = max(f(n-1)+arr[n]-arr[n-1], f(n-1)) n>1
     *
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = 0, dp1 = nums[0];
        for (int i = 1; i < n; ++i) {
            int tdp0 = Math.max(dp0, dp1); // 计算 dp[i][0]
            int tdp1 = dp0 + nums[i]; // 计算 dp[i][1]
            dp0 = tdp0; // 用 dp[i][0] 更新 dp_0
            dp1 = tdp1; // 用 dp[i][1] 更新 dp_1
        }
        return Math.max(dp0, dp1);
    }
}
