package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_0121_BestTimeToBuyAndSellStock {
    @Test
    public void test() {
        int num = maxProfit(new int[]{7,1,5,3,6,4});
        Logger.log(num);
    }

    /**
     * 			Runtime:2 ms, faster than 91.39% of Java online submissions.
     * 			Memory Usage:51.2 MB, less than 66.36% of Java online submissions.
     *
     * f(n)=0 prices.length<2
     * f(n) = prices[n]-prices[min(n-1)]
     * max = max(f(n))
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length<2) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            int profit = prices[i] - min;
            maxProfit = Math.max(profit, maxProfit);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

}
