package hans.leetcode.tree.bst;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 同783
 */
public class Easy0938_RangeSumOfBST {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{10,5,15,3,7,null,18});
        treeNode.prettyPrint();
        int mode = this.rangeSumBST(treeNode, 7,15);
        Logger.log(mode);
    }

    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null) {
            return sum;
        }
        if (root.val>=low && root.val<=high) {
            sum+=root.val;
        }
        if (root.val<=low) {
            rangeSumBST(root.right, low, high);
        } else if (root.val>=high) {
            rangeSumBST(root.left, low, high);
        } else {
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
