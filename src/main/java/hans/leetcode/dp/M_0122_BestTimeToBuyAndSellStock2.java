package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

public class M_0122_BestTimeToBuyAndSellStock2 {
    @Test
    public void test() {
        int num = maxProfit(new int[]{7,1,5,3,6,4});
        Logger.log(num);
    }


    /**
     * 1 2 5 100
     * 1 ,0
     * 1 2 ,1
     * 1 2 5 ,4
     * 3 1 2 5 1 100 ,99
     * buy min
     * sell latest max
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length<2) {
            return 0;
        }
        int minIdx = 0;
        int maxIdx = 0;
        int profit = 0;
        // f min
        // f max
        // min = next
        for (int i=1; i<prices.length; i++) {
            if (prices[i]<prices[minIdx]) {
                minIdx = i;
            } else {
                maxIdx = i;
            }
            if (prices[i]>prices[maxIdx]) {
                maxIdx = i;
            } else {

            }
        }
        return profit;
    }

}
