package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import org.junit.Test;


public class LeetcodeEasy543 {

    /**
     * TODO Time Complexity can be more optimized
     */
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7,8,9});
//
        System.out.println(this.diameterOfBinaryTree(treeNode));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int depth = diameterOfBinaryTreeDepth(root);
        int left = this.diameterOfBinaryTree(root.left);
        int right = this.diameterOfBinaryTree(root.right);
        return Math.max(depth,Math.max(left, right));
    }
    public int diameterOfBinaryTreeDepth(TreeNode root) {
        int leftDepth = this.diameterOfBinaryTree(root.left, 0);
        int rightDepth = this.diameterOfBinaryTree(root.right, 0);
        return leftDepth+rightDepth;
    }
    public int diameterOfBinaryTree(TreeNode root, int depth) {
        if (root==null) {
            return depth;
        }
        return Math.max(diameterOfBinaryTree(root.left, depth+1),diameterOfBinaryTree(root.right, depth+1));
    }
}
