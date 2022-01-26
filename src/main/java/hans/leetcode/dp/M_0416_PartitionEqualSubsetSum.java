package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 Given a non-empty array nums containing only positive integers, find if the
 array can be partitioned into two subsets such that the sum of elements in both
 subsets is equal.


 Example 1:


 Input: nums = [1,5,11,5]
 Output: true
 Explanation: The array can be partitioned as [1, 5, 5] and [11].


 Example 2:


 Input: nums = [1,2,3,5]
 Output: false
 Explanation: The array cannot be partitioned into equal sum subsets.



 Constraints:


 1 <= nums.length <= 200
 1 <= nums[i] <= 100

 Related Topics 数组 动态规划 👍 1098 👎 0

 */
public class M_0416_PartitionEqualSubsetSum {

    @Test
    public void test() {
        boolean result = this.canPartition(new int[]{1,5,11,5});
        Logger.log(result);
    }

    /**
     * 			Success:
     * 			Runtime:130 ms, faster than 5.08% of Java online submissions.
     * 			Memory Usage:39.2 MB, less than 23.39% of Java online submissions.
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int subSum = sum/2;
        // 和为奇数，肯定分不出来
        if (sum%2==1||Arrays.stream(nums).anyMatch(ele->ele>subSum)) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(nums[0]);
        for (int i=1; i<nums.length; i++) {
            Set<Integer> subSet = new HashSet<>();
            for (int csum: set) {
                int nsum = csum+nums[i];
                if (csum==subSum||nsum==subSum) {
                    return true;
                }
                if (csum<subSum) {
                    subSet.add(nsum);
                }
            }
            set.addAll(subSet);
        }
        return false;
    }
}
