package hans.leetcode.dp.climb;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_LCCI0801_ThreeStepsProblem {
    @Test
    public void test() {
        int num = waysToStep(76);
        Logger.log(num);
    }

    /**
     * 			Runtime:16 ms, faster than 72.38% of Java online submissions.
     * 			Memory Usage:35.1 MB, less than 87.20% of Java online submissions.
     * f(n) = 1 n=1
     * f(n) = 2 n=2
     * f(n) = 4 n=3
     * f(n) = f(n-1) + f(n-2) + f(n-3) n>3
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        if (n==3) {
            return 4;
        }
        long n1=1,n2=2,n3=4;
        long ni=0;
        for (long i=4; i<=n; i++) {
            ni = (n1+n2+n3)%1000000007;
            n1=n2;
            n2=n3;
            n3=ni;
        }
        return (int)ni;
    }

}
