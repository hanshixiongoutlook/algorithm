package hans.leetcode.dp.status;

import hans.common.utils.Logger;
import org.junit.Test;

public class M_0122_BestTimeToBuyAndSellStock2 {
    @Test
    public void test() {
        int num = maxProfit(new int[]{7,1,5,3,6,4});
        Logger.log(num);
    }


    /**
     * 			Runtime:3 ms, faster than 22.62% of Java online submissions.
     * 			Memory Usage:38.2 MB, less than 41.93% of Java online submissions.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length<2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1; i<prices.length; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

}
