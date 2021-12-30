package hans.leetcode.dp.matrix;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

public class M_0063_UniquePaths2 {
    @Test
    public void test() {
        int num = uniquePathsWithObstacles(new int[][]{
                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0}
        });
        Logger.log(num);
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:37.9 MB, less than 5.22% of Java online submissions.
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0]==1) {
            return 0;
        }
        int[][] arr = new int[obstacleGrid.length][obstacleGrid[0].length];
        arr[0][0] = 1;
        for (int i=1; i<obstacleGrid.length; i++) {
            arr[i][0] = arr[i-1][0];
            if (obstacleGrid[i][0]==1) {
                arr[i][0]=0;
            }
        }
        for (int i=1; i<obstacleGrid[0].length; i++) {
            arr[0][i] = arr[0][i-1];
            if (obstacleGrid[0][i]==1) {
                arr[0][i]=0;
            }
        }
        for (int i=1; i<obstacleGrid.length; i++) {
            for (int j=1; j<obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j]==1) {
                    arr[i][j]=0;
                } else {
                    arr[i][j] = arr[i][j-1]+arr[i-1][j];
                }
            }
        }
        return arr[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.4 MB, less than 5.31% of Java online submissions.
     * f(i,j) = f(i-1,j)+f(i,j-1);
     * f(0,j) = 1;
     * f(i,0) = 1;
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        Arrays.fill(arr[0], 1);
        for (int i=0; i<m; i++) {
            arr[i][0] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                arr[i][j] = arr[i][j-1]+arr[i-1][j];
            }
        }
        return arr[m-1][n-1];
    }


    int counter = 0;

    /**
     * 解法2 递归方式，效率很低
     * @param m
     * @param n
     */
    public void dfs(int m, int n) {
        if (m==0||n==0) {
            counter++;
            return;
        }
        if (m>0) {
            dfs(m-1, n);
        }
        if (n>0) {
            dfs(m, n-1);
        }
    }

}
