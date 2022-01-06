package hans.leetcode.dp.math;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 An ugly number is a positive integer whose prime factors are limited to 2, 3,
 and 5.

 Given an integer n, return the nᵗʰ ugly number.


 Example 1:


 Input: n = 10
 Output: 12
 Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10
 ugly numbers.


 Example 2:


 Input: n = 1
 Output: 1
 Explanation: 1 has no prime factors, therefore all of its prime factors are
 limited to 2, 3, and 5.



 Constraints:


 1 <= n <= 1690

 Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 804 👎 0

 */
public class M_0264_UglyNumber2 {

    @Test
    public void test() {
        int result = this.nthUglyNumber(1690);
        Logger.log(result);
    }

    /**
     * TODO 解法效率低
     * 			Runtime:48 ms, faster than 23.87% of Java online submissions.
     * 			Memory Usage:38.1 MB, less than 15.68% of Java online submissions.
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25,
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n==1) {
            return 1;
        }
        int[] factors = new int[]{2,3,5};
        Set<Long> dict = new HashSet<>();
        dict.add(1L);
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        Long urly = 0L;
        for (int i=0; i<n; i++) {
            urly = heap.poll();
            for (int f: factors) {
                Long num = urly*f;
                if (!dict.contains(num)) {
                    dict.add(num);
                    heap.offer(num);
                }
            }
        }
        return urly.intValue();
    }
}
