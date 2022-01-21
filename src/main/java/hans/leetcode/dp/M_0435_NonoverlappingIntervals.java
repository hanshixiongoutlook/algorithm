package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 Given an array of intervals intervals where intervals[i] = [starti, endi],
 return the minimum number of intervals you need to remove to make the rest of the
 intervals non-overlapping.


 Example 1:


 Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 Output: 1
 Explanation: [1,3] can be removed and the rest of the intervals are non-
 overlapping.


 Example 2:


 Input: intervals = [[1,2],[1,2],[1,2]]
 Output: 2
 Explanation: You need to remove two [1,2] to make the rest of the intervals non-
 overlapping.


 Example 3:


 Input: intervals = [[1,2],[2,3]]
 Output: 0
 Explanation: You don't need to remove any of the intervals since they're
 already non-overlapping.



 Constraints:


 1 <= intervals.length <= 10⁵
 intervals[i].length == 2
 -5 * 10⁴ <= starti < endi <= 5 * 10⁴

 Related Topics 贪心 数组 动态规划 排序 👍 585 👎 0

 */
public class M_0435_NonoverlappingIntervals {

    @Test
    public void test() {
        int result = this.eraseOverlapIntervals(new int[][]{new int[]{1,2},new int[]{1,2},new int[]{1,2},new int[]{2,3}});
        Logger.log(result);
    }

    /**
     * 			Success:
     * 			Runtime:55 ms, faster than 38.15% of Java online submissions.
     * 			Memory Usage:94.4 MB, less than 67.82% of Java online submissions.
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count=0;
        int preIdx=0;
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0]<intervals[preIdx][1]) {
                count++;
            } else {
                preIdx=i;
            }
        }
        return count;
    }
}
