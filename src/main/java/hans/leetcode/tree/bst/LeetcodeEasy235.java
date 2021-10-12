package hans.leetcode.tree;

import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LeetcodeEasy235 {

    @Test
    public void test() {
        int[] arr = new int[]{3,1,4,Integer.MIN_VALUE,2};
        TreeNode integerTreeNode = TreeNode.buildTree(arr);
        TreeNode treeNode = this.lowestCommonAncestor(integerTreeNode, new TreeNode(2, null, null,0), new TreeNode(3, null, null,0));
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        TreeNode next = root;
        while (next!=null) {
            if ((next.val-p.val)*(next.val- q.val)<=0) {
                break;
            }
            if (next.val<p.val) {
                next = next.right;
            } else {
                next = next.left;
            }
        }
        return next;
    }
}
