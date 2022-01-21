package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 An integer array is called arithmetic if it consists of at least three elements
 and if the difference between any two consecutive elements is the same.


 For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.



 Given an integer array nums, return the number of arithmetic subarrays of nums.


 A subarray is a contiguous subsequence of the array.


 Example 1:


 Input: nums = [1,2,3,4]
 Output: 3
 Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,
 3,4] itself.


 Example 2:


 Input: nums = [1]
 Output: 0



 Constraints:


 1 <= nums.length <= 5000
 -1000 <= nums[i] <= 1000

 Related Topics 数组 动态规划 👍 401 👎 0

 */
public class M_0413_ArithmeticSlices {

    @Test
    public void test() {
        int result = this.numberOfArithmeticSlices(new int[]{1,2,3,8,9,10});
        Logger.log(result);
    }

    /**
     * 			Success:
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:36.2 MB, less than 51.96% of Java online submissions.
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        /*
        1,2,3,4,5,7,9
        分析规律
        1~5，显然是1开头最长的等差数列，不难得出1~5所有个数>3连续子集合都是等差数列
           总个数=1~3,1~4,1~5,2~4,2~5,3~5
           可以看出：
           1开头的个数=5-2=3 1~5有5个元素
           2开头的个数=4-2=2 2~4有4个元素
           3开头的个数=3-2=1 3~5有3个元素
           总个数=3+2+1=6
        不难看出，这个最长数列的最大等差数列组合数=(endIdx-startIdx+1)-2  +  (endIdx-(startIdx+1)+1)-2 +...+ 1
        endIdx-startIdx+1 代表这个数组的长度
        显然这也是个等差数列，且差值为1
        因此总个数方程=(endIdx-startIdx-1)*((endIdx-startIdx+1)-2+1)/2 = (endIdx-startIdx-1)*(endIdx-startIdx)/2
                          项数                     项均值
        此时第一个等差数列计算完毕
        接下来计算第二个，此时，从上一个数列的最后一个元素开始继续找等差数列
        再按照上述方程计算即可
        然后累加所有等差数列组合之和
         */
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            int idx = calc(nums, i);
            if (idx>0) {
                count+=(idx-i-1)*(idx-i)/2;
                i=idx-1;
            }
        }
        return count;
    }
    public int calc(int[] nums, int idx) {
        // 不存在，长度至少为3
        if (idx>nums.length-3) {
            return -1;
        }
        int diff = nums[idx+1]-nums[idx];
        for (int i=idx+2; i<nums.length; i++) {
            if (nums[i]-nums[i-1]!=diff) {
                if (i-idx>1) {
                    return i-1;
                } else {
                    // 等差数列长度不足3不满足题目要求，返回-1
                    return -1;
                }
            }
        }
        // 剩余数据都符合等差要求，直接返回末尾元素索引
        return nums.length-1;
    }
}
