package hans.leetcode.dp.matrix;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1
 * "],["1","0","0","1","0"]]
 * Output: 4
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: matrix = [["0"]]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 978 👎 0
 */
public class M_0221_MaximalSquare {
    @Test
    public void test() {
        // [[1,3,1],[1,5,1],[4,2,1]]
        char[][] test = new char[300][300];
        for (int i = 1; i < 300; i++) {
            Arrays.fill(test[i], '1');
        }
        Arrays.fill(test[0], '0');
//        test[0][299] = '1';
//        test[99][122] = '0';
//
//        test[21][139] = '0';
        int num = maximalSquare(test);
        Logger.log(num);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        for (int x = 0; x < matrix.length; x++) {
            int bottomLen = matrix.length - x;
            if (bottomLen<= max) {
                return max*max;
            }
            for (int y = 0; y < matrix[0].length; y++) {
                int rightLen = matrix[0].length - y;
                int len = Math.min(rightLen, bottomLen);
                if (len <= max) {
                    break;
                }
                if (matrix[x][y] == '0') {
                    continue;
                }
                for (int i = 0; i < len; i++) {
                    int square = square(x, y, len - i, matrix);
                    max = Math.max(square, max);
                    if (square > 0) {
                        break;
                    }
                }
            }
        }
        return max*max;
    }

    public int square(int x, int y, int len, char[][] matrix) {
        int[] result = new int[2];
        if (len == 1) {
            if (matrix[x][y]=='1') {
                return 1;
            }
            return 0;
        }
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (matrix[i][j] == '0') {
                    return 0;
                }
            }
        }
        return len;
    }

}
