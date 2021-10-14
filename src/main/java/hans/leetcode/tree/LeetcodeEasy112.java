package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import org.junit.Test;


public class LeetcodeEasy112 {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
//
        System.out.println(this.hasPathSum(treeNode,22));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return false;
        }
        return hasPathSum(root, targetSum, 0);
    }
    public boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if (root==null) {
            return false;
        }
        sum+=root.val;
        if (sum==targetSum&&root.left==null&&root.right==null) {
            return true;
        }
        boolean left = hasPathSum(root.left, targetSum, sum);
        if (left) return true;
        boolean right = hasPathSum(root.right, targetSum, sum);
        return left||right;
    }
}
