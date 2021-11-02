package hans.leetcode.tree.bst;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 同783
 */
public class Easy0897_IncreasingOrderSearchTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,1,7});
        treeNode.prettyPrint();
        TreeNode mode = this.increasingBST(treeNode);
        mode.prettyPrint();
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        increasingBST(root, list);
        TreeNode rootNew = new TreeNode(list.get(0));
        TreeNode next = rootNew;
        for (int i = 1; i < list.size(); i++) {
            next.right = new TreeNode(list.get(i));
            next = next.right;
        }
        return rootNew;
    }
    public void increasingBST(TreeNode root, List<Integer> list) {
        if (root == null) return;
        increasingBST(root.left, list);
        list.add(root.val);
        increasingBST(root.right, list);
    }
}
