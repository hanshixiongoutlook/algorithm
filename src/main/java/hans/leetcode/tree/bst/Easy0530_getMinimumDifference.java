package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 * 同783
 */
public class Easy0530_getMinimumDifference {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{236,104,701,null,227,null,911});
        treeNode.prettyPrint();
        int mode = this.getMinimumDifference(treeNode);
        Logger.log(mode);
    }

    int diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root==null) {
            return -1;
        }
        if (root.left!=null) {
            int max = getMax(root.left);
            diff = Math.min(Math.abs(root.val-max), diff);
            getMinimumDifference(root.left);
        }
        if (root.right!=null) {
            int min = getMin(root.right);
            diff = Math.min(Math.abs(root.val-min), diff);
            getMinimumDifference(root.right);
        }
        return diff;
    }
    public int getMin(TreeNode root) {
        TreeNode next = root;
        while (next!=null) {
            if (next.left==null) {
                break;
            }
            next = next.left;
        }
        return next.val;
    }
    public int getMax(TreeNode root) {
        TreeNode next = root;
        while (next!=null) {
            if (next.right==null) {
                break;
            }
            next = next.right;
        }
        return next.val;
    }


}
