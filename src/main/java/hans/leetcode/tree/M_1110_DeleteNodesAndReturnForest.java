package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 */
public class M_1110_DeleteNodesAndReturnForest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,null,2,3,null,4,null,5});
        treeNode.prettyPrint();
        List<TreeNode> treeNodes = delNodes(treeNode, new int[]{5,3});
        for (TreeNode node: treeNodes) {
            node.arrayPrint();
        }

    }

    /**
     * 			Runtime:1 ms, faster than 93.16% of Java online submissions.
     * 			Memory Usage:39.1 MB, less than 27.13% of Java online submissions.
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        list = new LinkedList<>();
        for (int i: to_delete) {
            set.add(i);
        }
        dfs(root);
        if (set.contains(root.val)) {
            if (root.left!=null&&!set.contains(root.left.val)) {
                list.add(root.left);
            }
            if (root.right!=null&&!set.contains(root.right.val)) {
                list.add(root.right);
            }
        } else {
            list.add(root);
        }
        return list;
    }
    List<TreeNode> list;
    Set<Integer> set;
    public void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (root.left!=null && set.contains(root.left.val)) {
            if (root.left.left!=null&&!set.contains(root.left.left.val)) {
                list.add(root.left.left);
            }
            if (root.left.right!=null&&!set.contains(root.left.right.val)) {
                list.add(root.left.right);
            }
            root.left = null;
        }
        if (root.right!=null && set.contains(root.right.val)) {
            if (root.right.left!=null&&!set.contains(root.right.left.val)) {
                list.add(root.right.left);
            }
            if (root.right.right!=null&&!set.contains(root.right.right.val)) {
                list.add(root.right.right);
            }
            root.right = null;
        }
        dfs(left);
        dfs(right);
    }
}
