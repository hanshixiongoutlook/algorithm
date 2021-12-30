package hans.leetcode.dp.math;

import hans.common.utils.Logger;
import org.junit.Test;

public class E_1025_DivisorGame {
    @Test
    public void test() {
        boolean num = divisorGame(4);
        Logger.log(num);
    }

    /**
     *
     * @param n
     * @return
     */
    public boolean divisorGame(int n) {
        return n%2==0;
    }
}
