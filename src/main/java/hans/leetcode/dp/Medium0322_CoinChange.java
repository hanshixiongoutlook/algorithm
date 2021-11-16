package hans.leetcode.dp;

import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

public class Medium0322_CoinChange {

    @Test
    public void test() {

        int num = coinChange(new int[]{1,2,5}, 11);
        Logger.log(num);
        Logger.log(count);
    }
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
