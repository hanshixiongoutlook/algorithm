package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 Given an integer n, return the count of all numbers with unique digits, x,
 where 0 <= x < 10ⁿ.


 Example 1:


 Input: n = 2
 Output: 91
 Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 excluding 11,22,33,44,55,66,77,88,99


 Example 2:


 Input: n = 0
 Output: 1



 Constraints:


 0 <= n <= 8

 Related Topics 数学 动态规划 回溯 👍 170 👎 0

 */

public class M_0357_CountNumbersWithUniqueDigits {

    @Test
    public void test() {
        for (int i=0; i<=8; i++) {
            Logger.log("i={}, product={}", i, countNumbersWithUniqueDigits(i));
        }
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.3 MB, less than 24.93% of Java online submissions.
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        /*
            排列组合问题
            [0,9] 10个数字随机抽数组成n位数字，找出所有没有重复数字的个数

            第1位，n>1时第一位有9个选择，因为不能以0开头
            第2位，如果不和1重复，则有10-1=9种选择
            第3位，如果不和前两位重复，则有10-2种选择
            以此类推，第n位，有10-(n-1)=11-n中选择
            此时不难计算出，位数为n的有效结果数，f(n)=9x(10-1)x(10-2)x...x(10-n)
            注意这只是位数为n的有效数
            最终结果dp(n) = f(n)+f(n-1)
            这就是最终的状态方程

            基本状态：
            即位数为0,根据题意为1
            位数为1，为10
            接下来的结果均可通过状态方程计算了
         */

        int[] dp = new int[n+2];
        dp[0] = 1;
        dp[1] = 10;
        for (int i=2; i<=n; i++) {
            int count = 9;
            for (int j=1; j<i; j++) {
                count*=(10-j);
            }
            dp[i] = dp[i-1]+count;
        }
        return dp[n];
    }
}
