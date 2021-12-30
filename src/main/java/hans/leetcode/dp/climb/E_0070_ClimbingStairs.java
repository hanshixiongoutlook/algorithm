package hans.leetcode.dp.climb;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_0070_ClimbingStairs {
    @Test
    public void test() {
        int num = climbStairs(6);
        Logger.log(num);
    }

    /**
     * f(x) = f(x-1)+f(x-2); x>1
     * f(x) = 1 ; x=0,1
     *
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.3 MB, less than 7.91% of Java online submissions.
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<2) {
            return 1;
        }
        int pre = 1;
        int cur = 1;
        for (int i=2; i<=n;i++) {
            int sum = pre+cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

}
