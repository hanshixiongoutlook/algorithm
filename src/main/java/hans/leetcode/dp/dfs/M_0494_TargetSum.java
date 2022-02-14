package hans.leetcode.dp.dfs;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

/**
 You are given an integer array nums and an integer target.

 You want to build an expression out of nums by adding one of the symbols '+'
 and '-' before each integer in nums and then concatenate all the integers.


 For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 and concatenate them to build the expression "+2-1".


 Return the number of different expressions that you can build, which evaluates
 to target.


 Example 1:


 Input: nums = [1,1,1,1,1], target = 3
 Output: 5
 Explanation: There are 5 ways to assign symbols to make the sum of nums be
 target 3.
 -1 + 1 + 1 + 1 + 1 = 3
 +1 - 1 + 1 + 1 + 1 = 3
 +1 + 1 - 1 + 1 + 1 = 3
 +1 + 1 + 1 - 1 + 1 = 3
 +1 + 1 + 1 + 1 - 1 = 3


 Example 2:


 Input: nums = [1], target = 1
 Output: 1



 Constraints:


 1 <= nums.length <= 20
 0 <= nums[i] <= 1000
 0 <= sum(nums[i]) <= 1000
 -1000 <= target <= 1000

 Related Topics 数组 动态规划 回溯 👍 1041 👎 0

 */
public class M_0494_TargetSum {

    @Test
    public void test() {
        int result = this.findTargetSumWays(new int[]{1,1,1,1}, 3);
        Logger.log("result={}", result);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum<target && -sum>target) {
            return 0;
        }
        exTarget = target;
        dfs(nums,0,0);
        return count;
    }
    int count = 0;
    int exTarget;
    public void dfs(int[] nums, int target, int idx) {
        if (idx>=nums.length) {
            count +=  (target==exTarget?1:0);
            return ;
        }
        dfs(nums, target+nums[idx], idx+1);
        dfs(nums, target-nums[idx], idx+1);
    }
}
