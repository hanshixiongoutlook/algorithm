package hans.leetcode.tree.bst.operate;

import hans.common.pojo.TreeNode;
import org.junit.Test;

public class M_0701_InsertIntoABinarySearchTree {
    @Test
    public void test() {
        TreeNode integerTreeNode = TreeNode.buildTree(new Integer[]{4,2,7,1,3});
        integerTreeNode.prettyPrint();
        TreeNode treeNode = this.insertIntoBST(integerTreeNode, 5);
        treeNode.prettyPrint();
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:39.2 MB, less than 18.09% of Java online submissions
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) {
            return new TreeNode(val);
        }
        if (root.val>val) {
            if (root.left==null) {
                TreeNode node = new TreeNode(val);
                root.left = node;
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        } else if (root.val<val) {
            if (root.right==null) {
                TreeNode node = new TreeNode(val);
                root.right = node;
            } else {
                root.right = insertIntoBST(root.right, val);
            }
        }
        return root;

    }
}
