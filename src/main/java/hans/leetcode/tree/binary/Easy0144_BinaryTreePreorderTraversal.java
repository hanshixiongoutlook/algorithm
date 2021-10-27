package hans.leetcode.tree.binary;

import hans.algorithm.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Easy0144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preOrder(root,list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root==null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
