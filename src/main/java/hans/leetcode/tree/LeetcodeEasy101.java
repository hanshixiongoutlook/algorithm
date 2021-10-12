package hans.leetcode.tree;

import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LeetcodeEasy101 {
    @Test
    public void test() {
        TreeNode tree1 = TreeNode.buildTree(new int[]{1,2,2,3,4,4,3});
        boolean treeNode = isSymmetric(tree1);

        System.out.println(treeNode);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }

    private boolean isSymmetricChild(TreeNode left, TreeNode right) {
        if (left==null&&left==right) {
            return true;
        }
        if ((left==null||right==null)&&left!=right) {
            return false;
        }
        if (left.val!=right.val) {
            return false;
        }
        return isSymmetricChild(left.left, right.right)&&isSymmetricChild(left.right, right.left);
    }
}
