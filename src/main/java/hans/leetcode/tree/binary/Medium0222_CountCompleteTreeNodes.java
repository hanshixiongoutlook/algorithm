package hans.leetcode.tree.binary;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Runtime:1 ms, faster than 83.25% of Java online submissions.
 Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
 */
public class Medium0222_CountCompleteTreeNodes {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,5,4,6,7,8});
        treeNode.prettyPrint();
        Logger.log2Json(countNodes(treeNode));

    }

    int count=0;
    public int countNodes(TreeNode root) {
        if (root==null) {
            return count;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

}