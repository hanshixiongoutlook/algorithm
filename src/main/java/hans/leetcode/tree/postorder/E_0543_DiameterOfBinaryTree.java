package hans.leetcode.tree.postorder;


import hans.common.pojo.TreeNode;
import org.junit.Test;


public class E_0543_DiameterOfBinaryTree {

    /**
     * TODO Time Complexity can be more optimized
     */
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7,8,9});
//
        System.out.println(this.diameterOfBinaryTree(treeNode));
    }
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=1;
        if (root==null) {
            return 0;
        }
        diameterOfBinaryTreeDepth(root);
        return max-1;
    }
    public int diameterOfBinaryTreeDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftDepth = this.diameterOfBinaryTreeDepth(root.left);
        int rightDepth = this.diameterOfBinaryTreeDepth(root.right);
        max = Math.max(max, leftDepth+rightDepth+1);
        return Math.max(leftDepth,rightDepth)+1;
    }

}
