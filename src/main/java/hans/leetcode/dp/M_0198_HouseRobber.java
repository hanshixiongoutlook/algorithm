package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 You are a professional robber planning to rob houses along a street. Each house
 has a certain amount of money stashed, the only constraint stopping you from
 robbing each of them is that adjacent houses have security systems connected and
 it will automatically contact the police if two adjacent houses were broken into
 on the same night.

 Given an integer array nums representing the amount of money of each house,
 return the maximum amount of money you can rob tonight without alerting the police.



 Example 1:


 Input: nums = [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.


 Example 2:


 Input: nums = [2,7,9,3,1]
 Output: 12
 Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (
 money = 1).
 Total amount you can rob = 2 + 9 + 1 = 12.



 Constraints:


 1 <= nums.length <= 100
 0 <= nums[i] <= 400

 Related Topics 数组 动态规划 👍 1819 👎 0

 */
public class M_0198_HouseRobber {

    @Test
    public void test() {
        int result = this.rob(new int[]{2,7,9,3,1});
        Logger.log(result);
    }
    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.8 MB, less than 51.72% of Java online submissions.
     *
     * 1,2,3,1
     * f(n)[0] = a[0]  n=0
     * f(n)[1] = 0
     *
     * f(n)[0] = f(n-1)[1] + a[n]
     * f(n)[1] = Math.max(f(n-1)[0],f(n-1)[1])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length<1) {
            return 0;
        }
        int f0 = nums[0];
        int f1 = 0;
        int max = nums[0];

        for (int i=1; i<nums.length; i++) {
            int cf0 = f1+nums[i];
            int cf1 = Math.max(f0, f1);
            f0 = cf0;
            f1 = cf1;
            max = Math.max(cf0, max);
        }
        return max;
    }
}
