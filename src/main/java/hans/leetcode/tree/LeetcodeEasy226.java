package hans.leetcode.tree;

import hans.algorithm.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
 */
public class LeetcodeEasy226 {

    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
