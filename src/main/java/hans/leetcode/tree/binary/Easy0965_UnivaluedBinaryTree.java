package hans.leetcode.tree.binary;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;


public class Easy0965_UnivaluedBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2,2,2,2,2});
        treeNode.prettyPrint();
        boolean result = this.isUnivalTree(treeNode);
        // [3.00000,14.50000,11.00000]
        Logger.log(result);
    }
    public boolean isUnivalTree(TreeNode root) {
        if (root==null) {
            return true;
        }
        int curValue = root.val;
        if (root.left!=null&&curValue!=root.left.val) {
            return false;
        }
        if (root.right!=null&&curValue!=root.right.val) {
            return false;
        }
        boolean left = isUnivalTree(root.left);
        if (!left) {
            return left;
        }
        boolean right = isUnivalTree(root.right);
        return right;
    }

}
