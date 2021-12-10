package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class M_0669_TrimABinarySearchTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildSearchTree(new int[]{1, 2, 3, 4, 5});
        treeNode.prettyPrint();
        TreeNode treeNode1 = trimBST(treeNode, 2, 5);
        treeNode1.prettyPrint();

    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:37.6 MB, less than 98.24% of Java online submissions.
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        int v = root.val;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

}
