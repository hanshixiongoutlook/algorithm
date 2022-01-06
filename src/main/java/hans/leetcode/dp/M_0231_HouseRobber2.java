package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 You are a professional robber planning to rob houses along a street. Each house
 has a certain amount of money stashed. All houses at this place are arranged in
 a circle. That means the first house is the neighbor of the last one. Meanwhile,
 adjacent houses have a security system connected, and it will automatically
 contact the police if two adjacent houses were broken into on the same night.

 Given an integer array nums representing the amount of money of each house,
 return the maximum amount of money you can rob tonight without alerting the police.



 Example 1:


 Input: nums = [2,3,2]
 Output: 3
 Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2)
 , because they are adjacent houses.


 Example 2:


 Input: nums = [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.


 Example 3:


 Input: nums = [1,2,3]
 Output: 3



 Constraints:


 1 <= nums.length <= 100
 0 <= nums[i] <= 1000

 Related Topics 数组 动态规划 👍 879 👎 0

 */
public class M_0231_HouseRobber2 {

    @Test
    public void test() {
        int result = this.rob(new int[]{1,2,3});
        Logger.log(result);
    }
    /**
     * 			Success:
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.9 MB, less than 19.31% of Java online submissions.
     * 		状态方程参考 198
     * 	这里只是对前3个元素和最后一个元素做了特殊处理
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length<1) {
            return 0;
        }
        if (nums.length<2) {
            return nums[0];
        }
        if (nums.length<3) {
            return Math.max(nums[0],nums[1]);
        }
        if (nums.length<4) {
            return Math.max(Math.max(nums[0], nums[1]),nums[2]);
        }
        // 0 不偷
        int f0 = 0;
        int f1 = 0;
        int max = nums[1];

        for (int i=1; i<nums.length; i++) {
            int cf0 = f1+nums[i];
            int cf1 = Math.max(f0, f1);
            f0 = cf0;
            f1 = cf1;
            max = Math.max(cf0, max);
        }

        f0 = nums[2]+nums[0];
        f1 = nums[0];
        max = Math.max(f0, max);
        for (int i=3; i<nums.length; i++) {
            int cf0 = f1+nums[i];
            int cf1 = Math.max(f0, f1);
            if (i== nums.length-1) {
                cf0 = f0;
                cf1 = f1;
            }
            f0 = cf0;
            f1 = cf1;
            max = Math.max(f0, max);
        }
        return max;
    }
}
