package hans.leetcode.dp.dfs;

import hans.common.utils.Logger;
import org.junit.Test;

public class M_0055_JumpGame {
    @Test
    public void test() {
        boolean num = canJump(new int[]{2,0,0,4});
        Logger.log(num);
    }

    /**
     * 			Runtime:2 ms, faster than 95.11% of Java online submissions.
     * 			Memory Usage:40.5 MB, less than 5.19% of Java online submissions.
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length<=1) {
            return true;
        }
        return dfs(nums, 0);
    }
    public boolean dfs(int[] nums, int idx) {
        int distance = idx+nums[idx];
        if (distance>=nums.length-1) {
            return true;
        }
        if (nums[idx]==0) {
            return false;
        }
        int newIdx = idx;
        for (int j=idx+1; j<=idx+nums[idx]; j++) {
            int curDis = j+nums[j];
            if (curDis>distance) {
                distance = curDis;
                newIdx = j;
            }
        }
        if (newIdx==idx) {
            return false;
        }
        return dfs(nums, newIdx);
    }

}
