package hans.leetcode.dp.climb;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_0756_MinCostClimbingStairs {
    @Test
    public void test() {
        // 10,15,20 => 15
        // 1,100,1,1,1,100,1,1,100,1 => 6
        int num = minCostClimbingStairs(new int[]{1,100});
        Logger.log(num);
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:38.2 MB, less than 18.11% of Java online submissions.
     * f(n) = min(f(n-2),f(n-1))+cost[n] n>1
     * f(n) = 0 n<=1
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length<2) {
            return 0;
        }
        int pCost = cost[1];
        int ppCost = cost[0];
        int curCost = 0;
        for (int i=2; i<=cost.length; i++) {
            curCost = Math.min(pCost, ppCost);
            if (i==cost.length) {
                break;
            }
            ppCost = pCost;
            pCost = curCost+cost[i];
        }
        return curCost;
    }
}
