package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 */
public class M_1026_MaximumDifferenceBetweenNodeAndAncestor {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{2,4,3,1,null,0,5,null,6,null,null,null,7});
        treeNode1.prettyPrint();

        int i = maxAncestorDiff(treeNode1);

        Logger.log(i);

    }

    /**
     Runtime:85 ms, faster than 15.38% of Java online submissions.
     Memory Usage:126.6 MB, less than 5.13% of Java online submissions.
     */
    int max = -1;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,new LinkedList<>());
        return max;
    }
    public void dfs(TreeNode root, Deque<Integer> deque) {
        if (root==null) {
            return;
        }
        for (int i: deque) {
            int diff = Math.abs(i-root.val);
            max = Math.max(max, diff);
        }
        deque.offer(root.val);
        dfs(root.left, deque);
        dfs(root.right, deque);
        deque.removeLast();
    }
}
