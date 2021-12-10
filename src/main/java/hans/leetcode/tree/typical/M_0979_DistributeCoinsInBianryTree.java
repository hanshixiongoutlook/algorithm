package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class M_0979_DistributeCoinsInBianryTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{0,0,1,0,3,2});
        treeNode1.prettyPrint();

        Logger.log(distributeCoins(treeNode1));
    }

    int ans;

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.5 MB,击败了94.65% 的Java用户
     * @param root
     * @return
     */
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left)+Math.abs(right);
        return root.val-1+left+right;
    }
}
