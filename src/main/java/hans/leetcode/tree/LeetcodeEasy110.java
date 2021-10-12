package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class LeetcodeEasy110 {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,2,3,3,null,null,4,4});
//
        System.out.println(this.isBalanced(treeNode));
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        int leftL = this.depth(root.left, 0);
        int rightL = this.depth(root.right, 0);
        if (Math.abs(leftL-rightL)>1) {
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left&&right;
    }

    public int depth(TreeNode root, int depth) {
        if (root==null) {
            return depth;
        }
        return Math.max(depth(root.left, depth+1), depth(root.right, depth+1));
    }
}
