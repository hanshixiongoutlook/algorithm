package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

public class M_0322_CoinChange {

    @Test
    public void test() {
        Solution1 solution1 = new Solution1();
        int i = solution1.coinChange(new int[]{11, 1, 5}, 11);
        Solution2 solution2 = new Solution2();
        int i2 = solution2.coinChange(new int[]{11, 1, 5}, 11);
        Logger.log("min="+i+" ,count="+solution1.count);
        Logger.log("min="+i2+" ,count="+solution2.count);

        Logger.log("min="+coinChange(new int[]{11, 1, 5}, 11));
    }


    /**
     * 非递归方式
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=0; i<dp.length; i++) {
            for (int coin: coins) {
                if (i-coin<0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
    /**
     * 使用字典减少递归次数
     */
    class Solution2 {
        int[] dp;
        int count=0;
        public int coinChange(int[] coins, int amount) {
            dp = new int[amount+1];
            Arrays.fill(dp, -999);
            return dp(coins, amount);
        }
        public int dp(int[] coins, int amount) {
            // base case
            if (coins==null||coins.length==0||amount<0) {
                return -1;
            }
            if (amount==0) {
                return 0;
            }
            if (dp[amount]!=-999) {
                return dp[amount];
            }
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                count++;
                int sub = dp(coins, amount-coin);
                if (sub<0) {
                    continue;
                }
                min = Math.min(min, sub+1);
            }
            dp[amount] = min==Integer.MAX_VALUE?-1:min;
            return dp[amount];
        }
    }
    /**
     * 穷举递归，效率最低
     */
    class Solution1 {
        int count=0;
        public int coinChange(int[] coins, int amount) {
            return dp(coins, amount);
        }
        public int dp(int[] coins, int amount) {
            // base case
            if (coins==null||coins.length==0||amount<0) {
                return -1;
            }
            if (amount==0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                count++;
                int sub = dp(coins, amount-coin);
                if (sub<0) {
                    continue;
                }
                min = Math.min(min, sub+1);
            }
            return min==Integer.MAX_VALUE?-1:min;
        }
    }
}
