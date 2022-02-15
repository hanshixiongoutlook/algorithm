package hans.leetcode.dp.matrix;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

/**
 Given an m x n binary matrix mat, return the distance of the nearest 0 for each
 cell.

 The distance between two adjacent cells is 1.


 Example 1:


 Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 Output: [[0,0,0],[0,1,0],[0,0,0]]


 Example 2:


 Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 Output: [[0,0,0],[0,1,0],[1,2,1]]



 Constraints:


 m == mat.length
 n == mat[i].length
 1 <= m, n <= 10⁴
 1 <= m * n <= 10⁴
 mat[i][j] is either 0 or 1.
 There is at least one 0 in mat.

 Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 600 👎 0

 */
public class M_0542_Matrix {
    @Test
    public void test() {
        // [[1,3,1],[1,5,1],[4,2,1]]
        int[][] test = new int[3][3];
        for (int i = 0; i < test.length; i++) {
            Arrays.fill(test[i], 1);
        }
        test[1][1] = 0;
//        test[2][0] = 0;
        long start = System.currentTimeMillis();
        int[][] num = updateMatrix(test);
        long end = System.currentTimeMillis();
        Logger.log("time interval = {}", end-start);
        Logger.log("原始矩阵：");
        for (int i=0; i<num.length; i++) {
            Logger.log(test[i]);
        }

        Logger.log("结果：");
        for (int i=0; i<num.length; i++) {
            Logger.log(num[i]);
        }
    }

    /**
     * 			Runtime:1521 ms, faster than 5.03% of Java online submissions.
     * 			Memory Usage:45 MB, less than 5.42% of Java online submissions.
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        /*
        当前为0，则最近的0距离=0
        当前为1，则需要找，相邻有0则，距离=1，相邻没有则每走一步距离+1
        矩阵中至少有1个0

        原始矩阵      step 1     step 2     step 3
        1 1 1       - - -      - - -      - - 2
        1 1 1  ==>  - - -  ==> - - 1  ==> - 2 1
        1 1 0       - - 0      - 1 0      2 1 0

        1 1 1 1       0 - - -      0 1 - -      0 1 2 -
        1 1 0 1  ==>  - - - -  ==> 1 - - -  ==> 1 2 - 2
        1 1 1 1       - - - -      - - - 1      2 - 2 1
        1 1 1 0       - - - 0      - - 1 0      - 2 1 0
        看一个例子
        规律：
        1.本身为0的，距离可以直接设置为0
        2.0相邻的元素，如果为1，最小距离则为1

        状态方程：
        dp[i][j] = min(dp[i-1][j],dp[i+1][j],dp[i][j-1],dp[i][j+1]) + 1   mat[i][j]=1
        dp[i][j] = 0 mat[i][j]=0

        需要按层次标记距离
        首先标记距离为0的
        然后标记1、2...
        直到所有的元素都被标记，最大距离，即对角距离=width+height-2，即最多标记width+height-2轮即可

         */
        if (mat.length==1&&mat[0].length==1) {
            return mat;
        }
        int[][] res = new int[mat.length][mat[0].length];
        for (int i=0; i< res.length; i++) {
            for (int j=0;j<res[0].length; j++) {
                if (mat[i][j]==0) {
                    res[i][j]=0;
                }
                else res[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i=0; i<mat.length+mat[0].length-2; i++) {
            traversal(mat, res, i);
        }
        return res;
    }

    public void traversal(int[][] mat, int[][] res, int distance) {
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                if (res[i][j]==distance) {
                    fillAjacent(mat, res, i-1, j);
                    fillAjacent(mat, res, i+1, j);
                    fillAjacent(mat, res, i, j-1);
                    fillAjacent(mat, res, i, j+1);
                }
            }
        }
    }

    public void fillAjacent(int[][] mat, int[][] res, int i, int j) {
        if (i<0||i>mat.length-1||j<0||j>mat[0].length-1||res[i][j]!=Integer.MAX_VALUE) {
            return;
        }
        int top = i==0?Integer.MAX_VALUE:res[i-1][j];
        int bottom = i>=mat.length-1?Integer.MAX_VALUE:res[i+1][j];
        int left = j==0?Integer.MAX_VALUE:res[i][j-1];
        int right = j>=mat[i].length-1?Integer.MAX_VALUE:res[i][j+1];
        int ajacentDist = Math.min(Math.min(top, bottom),Math.min(left, right)) + 1;
        if (mat[i][j]==1 && res[i][j]==Integer.MAX_VALUE) {
            res[i][j] = ajacentDist;
        }
        if (mat[i][j]==1 && res[i][j]==Integer.MAX_VALUE) {
            res[i][j] = ajacentDist;
        }
        if (mat[i][j]==1 && res[i][j]==Integer.MAX_VALUE) {
            res[i][j] = ajacentDist;
        }
        if (mat[i][j]==1 && res[i][j]==Integer.MAX_VALUE) {
            res[i][j] = ajacentDist;
        }
    }

}
