package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

public class E_0338_CountingBits {
    @Test
    public void test() {
        int[] num = countBits(8);
        Logger.log(num);
    }


    int[] dic;

    /**
     * 			Runtime:3 ms, faster than 18.23% of Java online submissions.
     * 			Memory Usage:41.9 MB, less than 95.14% of Java online submissions.
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        dic = new int[n + 1];
        Arrays.fill(dic, -1);
        int[] arr = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            arr[i] = count(i);
        }
        return arr;
    }

    /**
     * 计算二进制中1的个数
     *
     * @param n
     * @return
     */
    public int count(int n) {
        if (n == 0) {
            return 0;
        }
        if (dic[n] >= 0) {
            return dic[n];
        }
        int count = n % 2 + count(n / 2);
        dic[n] = count;
        return dic[n];
    }

}
