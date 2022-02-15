package hans.leetcode.dp.math;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 You are given an integer array nums. The adjacent integers in nums will perform
 the float division.


 For example, for nums = [2,3,4], we will evaluate the expression "2/3/4".


 However, you can add any number of parenthesis at any position to change the
 priority of operations. You want to add these parentheses such the value of the
 expression after the evaluation is maximum.

 Return the corresponding expression that has the maximum value in string
 format.

 Note: your expression should not contain redundant parenthesis.


 Example 1:


 Input: nums = [1000,100,10,2]
 Output: "1000/(100/10/2)"
 Explanation:
 1000/(100/10/2) = 1000/((100/10)/2) = 200
 However, the bold parenthesis in "1000/((100/10)/2)" are redundant, since they
 don't influence the operation priority. So you should return "1000/(100/10/2)".
 Other cases:
 1000/(100/10)/2 = 50
 1000/(100/(10/2)) = 50
 1000/100/10/2 = 0.5
 1000/100/(10/2) = 2


 Example 2:


 Input: nums = [2,3,4]
 Output: "2/(3/4)"


 Example 3:


 Input: nums = [2]
 Output: "2"



 Constraints:


 1 <= nums.length <= 10
 2 <= nums[i] <= 1000
 There is only one optimal division for the given iput.

 Related Topics 数组 数学 动态规划 👍 78 👎 0

 */
public class M_0553_OptimalDivision {

    @Test
    public void test() {
        String result = this.optimalDivision(new int[]{1,2,3,4});
        Logger.log(result);
    }

    /**
     * 无脑数学题
     * 			Runtime:12 ms, faster than 16.26% of Java online submissions.
     * 			Memory Usage:39.8 MB, less than 6.51% of Java online submissions.
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {
        if (nums.length==1) {
            return nums[0]+"";
        }
        if (nums.length==2) {
            return nums[0]+"/"+nums[1];
        }
        String res = nums[0] + "/(";
        for (int i=1; i<nums.length-1; i++) {
            res += nums[i]+"/";
        }
        res+=nums[nums.length-1]+")";
        return res;
    }
}
