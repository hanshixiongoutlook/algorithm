package hans.leetcode.tree;

import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LeetcodeEasy104 {
    @Test
    public void test() {
        TreeNode tree1 = TreeNode.buildTree(new int[]{1,2,2,3,4,4,3});
        int treeNode = maxDepth(tree1);

        System.out.println(treeNode);
    }
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int depth) {
        if (root==null) {
            return depth;
        }
        return Math.max(maxDepth(root.left, depth+1),maxDepth(root.right, depth+1));
    }
}
