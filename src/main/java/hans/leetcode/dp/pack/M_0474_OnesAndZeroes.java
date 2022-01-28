package hans.leetcode.dp.pack;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 You are given an array of binary strings strs and two integers m and n.

 Return the size of the largest subset of strs such that there are at most m 0
 's and n 1's in the subset.

 A set x is a subset of a set y if all elements of x are also elements of y.


 Example 1:


 Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 Output: 4
 Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001",
 "1", "0"}, so the answer is 4.
 Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 {"111001"} is an invalid subset because it contains 4 1's, greater than the
 maximum of 3.


 Example 2:


 Input: strs = ["10","0","1"], m = 1, n = 1
 Output: 2
 Explanation: The largest subset is {"0", "1"}, so the answer is 2.



 Constraints:


 1 <= strs.length <= 600
 1 <= strs[i].length <= 100
 strs[i] consists only of digits '0' and '1'.
 1 <= m, n <= 100

 Related Topics 数组 字符串 动态规划 👍 624 👎 0

 */
public class M_0474_OnesAndZeroes {

    @Test
    public void test() {
        int result = this.findMaxForm(new String[]{"10","0","1"},1,1);
        Logger.log(result);
    }

    /**
     * 			Runtime:68 ms, faster than 13.95% of Java online submissions.
     * 			Memory Usage:67.4 MB, less than 10.83% of Java online submissions.
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        /*
        dp[i][m][n]
        i-strs前i个元素
        m-0的个数
        n-1的个数
        val-最大使用个数
        --------------
        动态方程：
        dp[i][m][n] = dp[i-1][m][n]   m<count0 || n<count1
        dp[i][m][n] = max(dp[i-1][m][n],dp[i-1][m-count0][n-count1]+1) m>=count0 && n>=count1
        解析：
        当m<count0 || n<count1时，即第i个字符串中所包含的0或1的个数超过了m或n，此时，该字符串需要舍弃，
        因此，dp[i][m][n] = dp[i-1][m][n]

        而当m>=count0 && n>=count1时，就需要考虑使用第i个字符串和不使用第i个字符串两种情况下，哪个结果更大，从中选择大的那个
        不使用的情况，显然和上边一样
        dp[i][m][n] = dp[i-1][m][n]
        使用的情况，则为
        dp[i][m][n] = dp[i-1][m-count0][n-count1]
        从中取最大，即max(dp[i-1][m][n], dp[i-1][m-count0][n-count1])

        边界情况：
        显然dp[i][0][0]=0
        即，无论前多少个字符串，0个数为0,1的个数也为0时，能够使用的元素只能是0个
         */
        int[][][] dp = new int[strs.length][m+1][n+1];
        for (int i=1; i<=strs.length; i++) {
            int[] counts = countZeroAndOne(strs[i-1]);
            for (int mm=0; mm<=m; mm++) {
                for (int nn=0; nn<=n; nn++) {
                    dp[i][mm][nn] = dp[i-1][mm][nn];
                    if (mm>=counts[0]&&nn>=counts[1]) {
                        dp[i][mm][nn] = Math.max(dp[i-1][mm][nn], dp[i-1][mm-counts[0]][nn-counts[1]]+1);
                    }
                }
            }
        }
        return dp[strs.length-1][m][n];
    }

    public int[] countZeroAndOne(String s) {
        int count0 = 0;
        int count1 = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='0') {
                count0++;
            } else {
                count1++;
            }
        }
        return new int[]{count0,count1};
    }
}
