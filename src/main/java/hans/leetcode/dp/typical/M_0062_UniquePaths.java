package hans.leetcode.dp.typical;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

public class M_0062_UniquePaths {
    @Test
    public void test() {
        int num = uniquePaths(51,9);
        Logger.log(num);
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
