package hans.leetcode.tree.typical;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class E_0104_MaximumDepthOfBinaryTree {
    @Test
    public void test() {
        TreeNode tree1 = TreeNode.buildTree(new Integer[]{1,2,2,3,4,4,3});
        int treeNode = maxDepth(tree1);

        System.out.println(treeNode);
    }
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
