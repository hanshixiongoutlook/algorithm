package hans.leetcode.tree.bst;

import org.junit.Test;

/**
 * TODO 动态规划
 */
public class Medium0096_UniqueBinarySearchTree {

    @Test
    public void test() {
        int treeNode = this.numTrees(3);
        System.out.println(treeNode);
    }

    int[][] memo;
    public int numTrees(int n) {
        if (n==0) {
            return 0;
        }
        memo = new int[n+1][n+1];
        int build = this.build(1, n);
        return build;
    }

    public int build(int start, int end) {
        if (start>end) {
            return 1;
        }
        if (memo[start][end]!=0) {
            return memo[start][end];
        }
        int count = 0;
        for (int i=start; i<=end; i++) {
            int leftNodes = build(start, i-1);
            int rightNodes = build(i+1, end);
            count+=leftNodes*rightNodes;
        }
        memo[start][end] = count;
        return count;
    }
}
