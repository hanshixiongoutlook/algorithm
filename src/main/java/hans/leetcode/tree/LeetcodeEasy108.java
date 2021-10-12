package hans.leetcode.tree;

import hans.algorithm.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LeetcodeEasy108 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root,list);
        return list;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root==null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
