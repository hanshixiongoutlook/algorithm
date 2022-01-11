package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 Given an integer array nums, return the length of the longest strictly
 increasing subsequence.

 A subsequence is a sequence that can be derived from an array by deleting some
 or no elements without changing the order of the remaining elements. For
 example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].


 Example 1:


 Input: nums = [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
 length is 4.


 Example 2:


 Input: nums = [0,1,0,3,2,3]
 Output: 4


 Example 3:


 Input: nums = [7,7,7,7,7,7,7]
 Output: 1



 Constraints:


 1 <= nums.length <= 2500
 -10⁴ <= nums[i] <= 10⁴



 Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
 complexity?
 Related Topics 数组 二分查找 动态规划 👍 2140 👎 0

 */
public class M_0300_LongestIncreasingSubsequence {

    @Test
    public void test() {
        int result = this.lengthOfLIS(new int[]{10});
        Logger.log(result);
    }

    /**
     * 			Runtime:58 ms, faster than 70.58% of Java online submissions.
     * 			Memory Usage:38 MB, less than 73.75% of Java online submissions.
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        /*
          dp表示当前值为最大值时，能够组成的最长子数组
          dp(0) = 1; 基本状态，即nums[0]为最大值时的，子数组长度=1
          dp(n) = max(dp(i<n&&arr[n]>arr[i])) + 1 //
          result = max(dp(n))
         */
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int len = 0;
        for (int i=0; i<nums.length; i++) {
            int iMax = 0;
            for (int j=0; j<i; j++) {
                if (nums[i]>nums[j]) {
                    iMax = Math.max(iMax, dp[j]);
                }
            }
            dp[i] = iMax+1;
            len = Math.max(len, dp[i]);
        }
        return len;
    }
}
