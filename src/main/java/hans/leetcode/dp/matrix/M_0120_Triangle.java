package hans.leetcode.dp.matrix;

import com.google.common.collect.Lists;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_0120_Triangle {

    @Test
    public void test() {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = Lists.newArrayList();
        triangle.add(Lists.newArrayList(-10));
        int result = minimumTotal(triangle);
        Logger.log(result);
    }

    /**
     * 			Runtime:4 ms, faster than 36.92% of Java online submissions.
     * 			Memory Usage:38.3 MB, less than 5.12% of Java online submissions.
     *
     * 1
     * 1 2
     * 1 2 3
     * 1 2 3 4
     * dp[0][0] = arr[0][0] i=0
     * dp[i][j] = min(dp[i-1][j](j<i),dp[i-1][j-1](j>0)) + arr[i][j] i>0
     * target = min(dp[最后行])
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }

        int[][] dp = new int[triangle.size()][];
        dp[0] = new int[1];
        dp[0][0] = triangle.get(0).get(0);
        int min = dp[0][0];
        for (int row=1; row<triangle.size(); row++) {
            dp[row] = new int[row+1];
            for (int col=0; col<row+1; col++) {
                if (col==0) {
                    dp[row][col] = dp[row-1][col] + triangle.get(row).get(col);
                } else if (col==row) {
                    dp[row][col] = dp[row-1][col-1] + triangle.get(row).get(col);
                } else {
                    dp[row][col] = Math.min(dp[row-1][col],dp[row-1][col-1]) + triangle.get(row).get(col);
                }
                if (row==triangle.size()-1 && col==0) {
                    min = dp[row][col];
                }
                if (row==triangle.size()-1) {
                    min = Math.min(min, dp[row][col]);
                }
            }
        }
        return min;
    }
}
