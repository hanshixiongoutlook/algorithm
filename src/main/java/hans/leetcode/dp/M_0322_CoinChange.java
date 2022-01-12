package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
/**
 You are given an integer array coins representing coins of different
 denominations and an integer amount representing a total amount of money.

 Return the fewest number of coins that you need to make up that amount. If
 that amount of money cannot be made up by any combination of the coins, return -1.

 You may assume that you have an infinite number of each kind of coin.


 Example 1:


 Input: coins = [1,2,5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1


 Example 2:


 Input: coins = [2], amount = 3
 Output: -1


 Example 3:


 Input: coins = [1], amount = 0
 Output: 0



 Constraints:


 1 <= coins.length <= 12
 1 <= coins[i] <= 2³¹ - 1
 0 <= amount <= 10⁴

 Related Topics 广度优先搜索 数组 动态规划 👍 1651 👎 0

 */
public class M_0322_CoinChange {

    @Test
    public void test() {
        Logger.log("min2="+coinChange2(new int[]{2}, 3));
    }

    /**
     * 			Runtime:19 ms, faster than 25.59% of Java online submissions.
     * 			Memory Usage:38 MB, less than 27.57% of Java online submissions.
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        /*
        状态方程：dp[i] = min(dp[i-coin]+1) i-coin>0&&dp[i-coin]>0
        解释：i代表钱数，dp[i]代表凑成钱数i，最少需要多少个钱币，dp.len = amount+1
             i-coin即，使用一个coins中的币，剩下的钱需要多少个币只要从dp中取就行了前边已经计算过了，
             因此使用某个coin需要的总数为dp[i-coin]+1
             如果i<coin的话，肯定就不用用来凑钱了，所以需要跳过
        基本状态：dp[0]=0, 即凑0元需要的钱币数，显然凑0元需要0个
        结果：dp[amount]
         */
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i=0; i<=amount; i++) {
            for (int coin: coins) {
                // 当前coin不能用来凑钱，i-coin凑不出来都需要跳过重新选
                if (i-coin<0||dp[i-coin]==-1) {
                    continue;
                }
                if (dp[i]==-1) {
                    dp[i] = 1 + dp[i - coin];
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount];
    }
}
