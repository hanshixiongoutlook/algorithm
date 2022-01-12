package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

/**
 Given an integer n, break it into the sum of k positive integers, where k >= 2,
 and maximize the product of those integers.

 Return the maximum product you can get.


 Example 1:


 Input: n = 2
 Output: 1
 Explanation: 2 = 1 + 1, 1 × 1 = 1.


 Example 2:


 Input: n = 10
 Output: 36
 Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.



 Constraints:


 2 <= n <= 58

 Related Topics 数学 动态规划 👍 672 👎 0

 */
public class M_0343_IntegerBreak {

    @Test
    public void test() {
        for (int i=2; i<=20; i++) {
            Logger.log("i={}, product={}", i, integerBreak(i));
        }
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35 MB, less than 81.37% of Java online submissions.
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        /*
        10
        2 -> 1x1 = 1 sqrt1
        3 -> 1x2 = 2 sqrt3 x dp(3-sqrt3)
        4 -> 2x2 = 4
        5 -> 2x3 = 6
        6 -> 3x3 = 9 2 6/2=3 3x6-3
        7 -> 3x4 = 12 2 7/2=3 3x4
        8 -> 3x3x2 = 18 2 8/2=4 4x4
        9 -> 3x3x3 = 27
        10-> 3x3x4 = 36
        11-> 3x3x3x2
        12-> 3x
        13-> 3x3x3x4

        状态方程：dp[i] = max(dp(i-diff)*diff) 1<diff<i/2

        基本状态：
        因为2,3中都涉及x1问题，会使结果变小，6以内除2均小于3，因此也需要单独计算
         */
        int[] dp = new int[n+6];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i=7; i<=n; i++) {
            for (int j=2; j<i/2; j++) {
                dp[i] = Math.max(dp[i], j*dp[i-j]);
            }
        }
        return dp[n];
    }
}
