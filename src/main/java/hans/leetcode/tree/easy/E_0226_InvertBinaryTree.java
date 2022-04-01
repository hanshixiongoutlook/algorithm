package hans.leetcode.tree.easy;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 同 剑指27
 */
public class E_0226_InvertBinaryTree {
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7});
        treeNode.prettyPrint();
        this.invertTree(treeNode);
        treeNode.prettyPrint();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
