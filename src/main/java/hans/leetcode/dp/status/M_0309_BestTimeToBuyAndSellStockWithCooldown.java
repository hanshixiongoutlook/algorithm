package hans.leetcode.dp.status;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 * You are given an array prices where prices[i] is the price of a given stock on
 * the iᵗʰ day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions
 * as you like (i.e., buy one and sell one share of the stock multiple times) with
 * the following restrictions:
 * <p>
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 * <p>
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: prices = [1]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * <p>
 * Related Topics 数组 动态规划 👍 1019 👎 0
 */
public class M_0309_BestTimeToBuyAndSellStockWithCooldown {
    @Test
    public void test() {
        int num = maxProfit(new int[]{1, 2, 3, 0, 2});
        Logger.log(num);
    }


    /**
     Runtime:1 ms, faster than 89.94% of Java online submissions.
     Memory Usage:37.9 MB, less than 22.98% of Java online submissions.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        /* 股票问题核心状态是当前是否持股的收益
        对于本问题：可分为
        0-持股、1-不持股在冷冻期、2-不持股后不在冷冻期
        于是有了状态方程
        0-
        dp[i][0] = max(dp[i-1][0],dp[i-1][2]-prices[i]), 当前想持股：max(昨日已持股, 昨日未持股且不在冷冻期-当日股价)
        dp[i][1] = dp[i-1][0]+prices[i]
        dp[i][2] = max(dp[i-1][1],dp[i-1][2])
         */
        if (prices.length < 2) {
            return 0;
        }
        int[][] f = new int[prices.length][3];
        f[0][0] = -prices[0]; // 持股
        for (int i = 1; i < prices.length; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[prices.length - 1][1], f[prices.length - 1][2]);
    }

}
