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
        int[][] test = new int[300][300];
        for (int i = 1; i < 300; i++) {
            Arrays.fill(test[i], 1);
        }
        Arrays.fill(test[0], 0);
//        test[0][299] = '1';
//        test[99][122] = '0';
//
//        test[21][139] = '0';
        int[][] num = updateMatrix(test);
        Logger.log(num);
    }

    public int[][] updateMatrix(int[][] mat) {
        return traversal(mat);
    }

    public int[][] traversal(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                if (mat[i][j]!=0) {
                    res[i][j]=Math.min(res[i-1][j], res[i][j-1]);
                }
            }
        }
        return res;
    }

}
