package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

/**
 There is an m x n grid with a ball. The ball is initially at the position [
 startRow, startColumn]. You are allowed to move the ball to one of the four adjacent
 cells in the grid (possibly out of the grid crossing the grid boundary). You
 can apply at most maxMove moves to the ball.

 Given the five integers m, n, maxMove, startRow, startColumn, return the
 number of paths to move the ball out of the grid boundary. Since the answer can be
 very large, return it modulo 10⁹ + 7.


 Example 1:


 Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 Output: 6


 Example 2:


 Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 Output: 12



 Constraints:


 1 <= m, n <= 50
 0 <= maxMove <= 50
 0 <= startRow < m
 0 <= startColumn < n

 Related Topics 动态规划 👍 225 👎 0

 */
public class M_0576_OutOfBoundaryPaths {

    @Test
    public void test() {
        int result = this.findPaths(2,2,2, 0,0);
        Logger.log(result);
    }

    /**
     * 			Success:
     * 			Runtime:4 ms, faster than 85.74% of Java online submissions.
     * 			Memory Usage:40.6 MB, less than 6.41% of Java online submissions.
     * TODO 未解出
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        /*
        dp[m][x][y]
        m表示步数，x表示横坐标，y表示纵坐标
        值表示，移动m步，能够从(startRow,startColumn)->(x,y)的路径数

        边界情况
        // 0步->到起始位置，显然可行有一条
        dp[0][startRow][startColumn]=1
        // 0步->非起始位置，显然不存在任何路径
        dp[0][x][y]=0  x!startRow || y!=startColumn

        移动m步，(startRow,startColumn)->(x,y)
        如果0<=x<m && 0<=y<n，再挪一步没出界，则路径数dp[m+1][x][y]+1
        否则，出界了，出界数+1

        每次移动都有4个方向可以选择，即
           上    右     下      左
        [{0,1},{1,0},{0,-1},{-1,0}]

         */
        final int MOD = 1000000007;
        int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][][] dp = new int[maxMove+1][m][n];
        dp[0][startRow][startColumn] = 1;
        int outCount = 0;
        for (int i=0; i<maxMove; i++) {
            for (int x=0; x<m; x++) {
                for (int y=0; y<n; y++) {
                    int count = dp[i][x][y];
                    if (count>0) {
                        for (int[] dir: direct) {
                            int xx = x+dir[0];
                            int yy = y+dir[1];
                            if (xx>=0&&xx<m && yy>=0&&yy<n) {
                                dp[i+1][xx][yy] = (dp[i+1][xx][yy]+count)%MOD;
                            } else {
                                outCount = (outCount+count)%MOD;
                            }
                        }
                    }
                }
            }
        }
        return outCount;
    }
}
