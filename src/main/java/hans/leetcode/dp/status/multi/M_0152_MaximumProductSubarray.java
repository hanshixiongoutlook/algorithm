package hans.leetcode.dp.status.multi;

import hans.common.utils.Logger;
import org.junit.Test;
/**
 Given an integer array nums, find a contiguous non-empty subarray within the
 array that has the largest product, and return the product.

 The test cases are generated so that the answer will fit in a 32-bit integer.

 A subarray is a contiguous subsequence of the array.


 Example 1:


 Input: nums = [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.


 Example 2:


 Input: nums = [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.



 Constraints:


 1 <= nums.length <= 2 * 10⁴
 -10 <= nums[i] <= 10
 The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 integer.

 Related Topics 数组 动态规划 👍 1438 👎 0

 */
public class M_0152_MaximumProductSubarray {

    @Test
    public void test() {
        int result = this.maxProduct(new int[]{
                //0,-1,4,-4,5,-2,-1,-1,-2,-3,
               // 0,-3,
               // 0,1,-1,-4,4,6,2,3,
                //0,-5,2,1,-4,-2,-1,3,-4,-6,
                0,2,2,-1,-5,1,1,5,-6,2,1,-3,-6,-6,-3,4,
                //0,-2,
        //        0,2
        });
        Logger.log(result);
    }
    /**
     * f(n)[0] = 0 a[n]=0
     * f(n)[1] = 0 a[n]=0
     *
     * f(n)[0] = f(n-1)[0]*a[n] f(n-1)[0]*f(n-1)[1]<0
     * f(n)[1] = f(n-1)[1]*a[n]
     *
     * f(n)[0] = f(n-1)[0]*a[n] f(n-1)[0]*f(n-1)[1]>0
     * f(n)[1] = a[n]
     *
     * f(n)[0] = a[n] f(n-1)[0]*f(n-1)[1]==0
     * f(n)[1] = a[n]
     *
     * max = max(f(n)[0],f(n)[1],max)
     * 0,2,2,-1,-5,1,1,5,-6,2,1,-3,-6,-6,-3,4,
     * 2 2
     * 4 2
     * -4 -1
     * 20 -5
     * 20 -5
     * 20 -5
     * 100 -25
     * -600 150
     * -1200 300
     * -1200 300
     * 3600 -900
     * -21600 5400
     * xxxxx -32400
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length<1) {
            return 0;
        }
        // 连续乘积
        int f0 = nums[0];
        // f1和f0同号时，f1=nums[i]，因为nums[i]可能是最大值
        // 比如f0=f1=-8,nums[i]=100，
        // 此时代表连续乘积的f0会继续和nums[i]乘就成了-800，如果数组就此终止，最大值应该是100，
        // 因此f0和f1同号时，f1自动后移

        int f1 = nums[0];
        int max = nums[0];

        for (int i=1; i<nums.length; i++) {
            // 这里得注意下，f0和f1直接乘容易溢出
            int product = f0==0||f1==0?0:f0/Math.abs(f0)*f1;
            if (nums[i]==0) {
                f0 = 0;
                f1 = 0;
            } else if (product==0) {
                f0 = nums[i];
                f1 = nums[i];
            } else if (product>0) {
                f0 = f0*nums[i];
                f1 = nums[i];
            } else {
                f0 = f0*nums[i];
                f1 = f1*nums[i];
            }
            max = Math.max(max, f0);
            max = Math.max(max, f1);
        }
        return max;
    }
}
