package hans.leetcode.dp.typical.matrix;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

public class M_0064_MinimumPathSum {
    @Test
    public void test() {
        // [[1,3,1],[1,5,1],[4,2,1]]
        int num = minPathSum(new int[][]{
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}
        });
        Logger.log(num);
    }

    /**
     * 			Runtime:2 ms, faster than 96.54% of Java online submissions.
     * 			Memory Usage:41.4 MB, less than 5.25% of Java online submissions.
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];
        arr[0][0] = grid[0][0];
        // fill first column
        for (int i=1; i< grid.length; i++) {
            arr[i][0] = arr[i-1][0] + grid[i][0];
        }
        // fill first row
        for (int i=1; i< grid[0].length; i++) {
            arr[0][i] = grid[0][i] + arr[0][i-1];
        }
        for (int i=1; i<grid.length; i++) {
            for (int j=1; j<grid[0].length; j++) {
                arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1])+grid[i][j];
            }
        }
        return arr[grid.length-1][grid[0].length-1];
    }
}
