package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_1137_NthTribonacciNumber {
    @Test
    public void test() {
        int num = tribonacci(25);
        Logger.log(num);
    }

    /**
     * 		Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.2 MB, less than 28.68% of Java online submissions.
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n==0) {
            return 0;
        }
        if (n<3) {
            return 1;
        }
        int n_0 = 0;
        int n_1 = 1;
        int n_2 = 1;
        int nth = 0;
        for (int i=3; i<=n; i++) {
            nth = n_0+n_1+n_2;
            n_0 = n_1;
            n_1 = n_2;
            n_2 = nth;
        }
        return nth;
    }

}
