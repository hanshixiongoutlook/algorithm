package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 Given a positive integer n, you can apply one of the following operations:


 If n is even, replace n with n / 2.
 If n is odd, replace n with either n + 1 or n - 1.


 Return the minimum number of operations needed for n to become 1.


 Example 1:


 Input: n = 8
 Output: 3
 Explanation: 8 -> 4 -> 2 -> 1


 Example 2:


 Input: n = 7
 Output: 4
 Explanation: 7 -> 8 -> 4 -> 2 -> 1
 or 7 -> 6 -> 3 -> 2 -> 1


 Example 3:


 Input: n = 4
 Output: 2



 Constraints:


 1 <= n <= 2³¹ - 1

 Related Topics 贪心 位运算 记忆化搜索 动态规划 👍 215 👎 0

 */
public class M_0397_IntegerReplacement {

    @Test
    public void test() {
        int result = this.integerReplacement(2147483647);
        Logger.log(result);
    }

    /**
     * 			Success:
     * 			Runtime:1 ms, faster than 60.25% of Java online submissions.
     * 			Memory Usage:35.2 MB, less than 49.53% of Java online submissions.
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        /*
        典型递归，
        map作用仅仅是减少递归次数，不适用同样可以，不过时间会变长
         */
        return dfs(n);
    }
    Map<Long, Integer> map = new HashMap<>();
    public int dfs(long n) {
        if (n<2) {
            return 0;
        }
        if (map.containsKey(n)) {
            int v = map.get(n);
            return v;
        }
        int count;
        if (n%2==0) {
            count = dfs(n/2)+1;
        } else {
            count = Math.min(dfs((n-1)/2),dfs((n+1)/2)) +2;
        }
        map.put(n, count);
        return count;
    }
}
