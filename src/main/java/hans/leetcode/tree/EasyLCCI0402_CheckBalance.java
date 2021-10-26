package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;


/**
 * 同剑指55
 */
public class EasyLCCI0402_CheckBalance {

    @Test
    public void test() {
//        1,2,2,3,3,null,null,4,4
        // 3,9,20,null,null,15,7
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5});
        treeNode.prettyPrint();

        boolean result = this.isBalanced(treeNode);
        Logger.log(result);
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left-right)>1) {
            return false;
        }
        boolean leftIs = isBalanced(root.left);
        boolean rightIs = isBalanced(root.right);
        return leftIs&&rightIs;
    }
    public int depth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = depth(root.left)+1;
        int right = depth(root.right)+1;
        return Math.max(left, right);
    }
}
