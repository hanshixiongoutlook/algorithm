package hans.leetcode.dp.status;

import hans.common.utils.Logger;
import org.junit.Test;
/**
 Given an array of distinct integers nums and a target integer target, return
 the number of possible combinations that add up to target.

 The test cases are generated so that the answer can fit in a 32-bit integer.


 Example 1:


 Input: nums = [1,2,3], target = 4
 Output: 7
 Explanation:
 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)
 Note that different sequences are counted as different combinations.


 Example 2:


 Input: nums = [9], target = 3
 Output: 0



 Constraints:


 1 <= nums.length <= 200
 1 <= nums[i] <= 1000
 All the elements of nums are unique.
 1 <= target <= 1000



 Follow up: What if negative numbers are allowed in the given array? How does
 it change the problem? What limitation we need to add to the question to allow
 negative numbers?
 Related Topics 数组 动态规划 👍 555 👎 0

 */
public class M_0377_CombinationSum4 {
    @Test
    public void test() {
        int num = combinationSum4(new int[]{2,1,3}, 4);
        Logger.log(num);
    }

    /**
     * 			Runtime:1 ms, faster than 96.83% of Java online submissions.
     * 			Memory Usage:35.5 MB, less than 82.04% of Java online submissions.
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {

        /*
        1,2,3 | 4
        f(0,target) = f(0,target-nums[0])
        f(0) = 1
        f(1) = f(1-1) = 1
        f(2) = f(2-1)+f(2-2) = 2
        f(3) = f(3-1)+f(3-2)+f(3-3) = 4
        f(4) = f(4-1)+f(4-2)+f(4-3) = 7

        可以看到，状态转移的是target即目标值，
        f(n) = Σf(n-nums)
        f(0) = 1
         */
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=1; i<=target; i++) {
            int iCount = 0;
            for (int j=0; j<nums.length; j++) {
                if (nums[j]<=i) {
                    iCount+=dp[i-nums[j]];
                }
            }
            dp[i] = iCount;
        }
        return dp[target];
    }

    public int dfs(int[] nums, int target) {
        if (target<0) {
            return 0;
        }
        if (target==0) {
            return 1;
        }
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            int subCount = dfs(nums, target-nums[i]);
            count = subCount+count;
        }
        return count;
    }
}
