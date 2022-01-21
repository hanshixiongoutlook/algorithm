package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 You are given an integer array nums of length n.

 Assume arrk to be an array obtained by rotating nums by k positions clock-wise.
 We define the rotation function F on nums as follow:


 F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].


 Return the maximum value of F(0), F(1), ..., F(n-1).

 The test cases are generated so that the answer fits in a 32-bit integer.


 Example 1:


 Input: nums = [4,3,2,6]
 Output: 26
 Explanation:
 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.


 Example 2:


 Input: nums = [100]
 Output: 0



 Constraints:


 n == nums.length
 1 <= n <= 10⁵
 -100 <= nums[i] <= 100

 Related Topics 数学 动态规划 👍 96 👎 0

 */
public class M_0396_RotateFunction {

    @Test
    public void test() {
        int result = this.maxRotateFunction(new int[]{-8,5,-10,-5,-7,-2,-7,0});
        Logger.log(result);
    }

    /**
     * 			Success:
     * 			Runtime:4 ms, faster than 49.79% of Java online submissions.
     * 			Memory Usage:51.1 MB, less than 26.03% of Java online submissions.
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        /*
        这个题直接翻译题干是可以解出来的，但是时间复杂度为O(n²)，提交会超时，因此需要优化
         Input: nums = [4,3,2,6] Output: 26
         F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
         F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
         F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
         F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

         优化：从例子找规律
         F(1) 相对于F(0)
            损失了 (len-1)*nums[len-1] 即 3*6
            增加了 sum(nums)-nums[len-1] 即15-6=9
            因此F(1) = F(0) + (sum(nums)-nums[4-1]) - (4-1)*nums[4-1] = 25 + (15-6) - 3*6 =16
         同理
         F(2) 相对F(1)
            损失了 (len-1)*nums[len-2] 即 2*2=4
            增加了 sum(nums)-nums[len-2] 即15-2=13
            因此F(2) = F(1) + (sum(nums)-nums[4-2]) - (4-1)*nums[4-2] = 16 + (15-2) - 3*2 = 23
         因此状态方程为：
         F(N) = F(N-1) + (sum(nums)-nums[len-N]) - (len-1)*nums[len-N]
         max = Max(F(N))
         */
        int sum = 0;
        int fk = 0;
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            fk+=i*nums[i];
        }
        int max = fk;
        int len = nums.length;
        for (int i=1; i<len; i++) {
            fk = fk-(len-1)*nums[len-i] + (sum-nums[len-i]);
            max = Math.max(max, fk);
        }
        return max;
    }
}
