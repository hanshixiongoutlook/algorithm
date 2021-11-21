package hans.leetcode.tree.postorder;

import hans.algorithm.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
 */
public class Easy0145_BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root,list);
        return list;
    }

    public void postOrder(TreeNode root, List list) {
        if (root==null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
