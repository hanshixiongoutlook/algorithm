package hans.leetcode.dp.math;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 A super ugly number is a positive integer whose prime factors are in the array
 primes.

 Given an integer n and an array of integers primes, return the nᵗʰ super ugly
 number.

 The nᵗʰ super ugly number is guaranteed to fit in a 32-bit signed integer.


 Example 1:


 Input: n = 12, primes = [2,7,13,19]
 Output: 32
 Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 super ugly numbers given primes = [2,7,13,19].


 Example 2:


 Input: n = 1, primes = [2,3,5]
 Output: 1
 Explanation: 1 has no prime factors, therefore all of its prime factors are in
 the array primes = [2,3,5].



 Constraints:


 1 <= n <= 10⁶
 1 <= primes.length <= 100
 2 <= primes[i] <= 1000
 primes[i] is guaranteed to be a prime number.
 All the values of primes are unique and sorted in ascending order.

 Related Topics 数组 哈希表 数学 动态规划 堆（优先队列） 👍 291 👎 0

 */
public class M_0313_SuperUglyNumber {

    @Test
    public void test() {
        int result = this.nthSuperUglyNumber(1000000, new int[]{2,7,13,19});
        Logger.log(result);
    }

    /**
     * @param n
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // 2,5,7
        // 1 ,2, 5, 7
        // 4,10,14
        // 8,20,28
        /*
        有序丑数结果集：dp[0] = 1
        当前乘积集合：a1 size=primes
        1 a1 = dp[0]*primes
          dp[1] = min(a1)
        2 a1 = dp[1]*primes
          dp[2] = min(a1)
        i dp[i] = min(dp[i-1]*primes)
         */

        int[] dp = new int[n + 1];
        int m = primes.length;
        int[] pointers = new int[m];
        int[] nums = new int[m];
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; i++) {
            int minNum = Arrays.stream(nums).min().getAsInt();
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (nums[j] == minNum) {
                    pointers[j]++;
                    nums[j] = dp[pointers[j]] * primes[j];
                }
            }
        }
        return dp[n];
    }
}
