package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 Given a positive integer n, return the number of the integers in the range [0,
 n] whose binary representations do not contain consecutive ones.


 Example 1:


 Input: n = 5
 Output: 5
 Explanation:
 Here are the non-negative integers <= 5 with their corresponding binary
 representations:
 0 : 0
 1 : 1
 2 : 10
 3 : 11
 4 : 100
 5 : 101
 Among them, only integer 3 disobeys the rule (two consecutive ones) and the
 other 5 satisfy the rule.


 Example 2:


 Input: n = 1
 Output: 2


 Example 3:


 Input: n = 2
 Output: 3



 Constraints:


 1 <= n <= 10⁹

 Related Topics 动态规划 👍 272 👎 0

 */
public class M_0600_NonNegativeIntegersWithoutConsecutiveOnes {

    @Test
    public void test() {
        for (int i=1; i<100; i++) {
            int result = this.findIntegers(i);
            Logger.log("i={}, count={}",i, result);
        }
        /*
        0  0
        1  1
        2  10
        3  11
        4  100
        5  101
        6  110
        7  111
        8  1000
        9  1001
        10 1010
        11 1011
        12 1100
        13 1101
        14 1110
        15 1111
        16 10000
         */

    }

    public int findIntegers(int n) {
        /*
        i/2 0 i%2 == 0
        i/2 1 i%2 == 1
        dp[0] = 1,0,1
        dp[1] = 2,1,1
        dp[2] = 3,0,1
        dp[3] = 3,1,0
        dp[4] = 4,0,1
        dp[5] = 5,1,1

        状态方程：dp[i][3]
        含义：
        i为值为
        dp[i][0] 表示个数
        dp[i][1] 表示当前结尾为0或1
        dp[i][2] 表示当前数字是否有连续1,0表示有，1表示没有

        dp[i][1] = i%2
        dp[i][2] = 0 (dp[i/2][2]==0) || (dp[i/2][1]==1&&i%2==1)
                   1 否则
        dp[i][0] = dp[i-1][0] + dp[i][2]==1?1:0

         */

        int[][] dp = new int[n+1][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 1;

        for (int i=1; i<=n; i++) {
            dp[i][1] = i%2;
            if ( (dp[i/2][2]==0) || (dp[i/2][1]==1&&i%2==1) ) {
                dp[i][2] = 0;
            } else {
                dp[i][2] = 1;
            }
            int last = dp[i-1][0];
            int plus = dp[i][2]==1?1:0;
            dp[i][0] = last + plus;
        }
        return dp[n][0];
    }
}
