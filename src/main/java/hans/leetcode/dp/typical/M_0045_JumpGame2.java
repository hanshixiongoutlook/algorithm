package hans.leetcode.dp.typical;

import hans.common.utils.Logger;
import org.junit.Test;

public class M_0045_JumpGame2 {
    @Test
    public void test() {
        int num = jump(new int[]{2,4});
        Logger.log(num);
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:39.7 MB, less than 5.08% of Java online submissions.
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length<=1) {
            return 0;
        }
        dfs(nums, 0);
        return counter;
    }
    int counter = 0;
    public void dfs(int[] nums, int idx) {
        int distance = idx+nums[idx];
        if (distance>=nums.length-1) {
            counter++;
            return;
        }
        int newIdx = idx;
        for (int j=idx+1; j<=idx+nums[idx]; j++) {
            int curDis = j+nums[j];
            if (curDis>distance) {
                distance = curDis;
                newIdx = j;
            }
        }
        counter++;
        dfs(nums, newIdx);
    }

}
