package hans.leetcode.tree;


import com.alibaba.fastjson.JSONObject;
import hans.algorithm.pojo.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
 * 			Memory Usage:37.8 MB, less than 50.68% of Java online submissions.
 */
public class Medium0114_FlattenBinaryTreeToLinkedList {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5});
        treeNode.prettyPrint();
        flatten(treeNode);
        treeNode.prettyPrint();
    }
    TreeNode pre;
    public void flatten(TreeNode root) {
        if (root==null) {
            return;
        }
        if (pre!=null) {
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
    }

}
