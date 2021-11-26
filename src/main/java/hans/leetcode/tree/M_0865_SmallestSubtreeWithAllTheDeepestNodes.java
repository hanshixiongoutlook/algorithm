package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class M_0865_SmallestSubtreeWithAllTheDeepestNodes {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,0,0,0,0,1,0});
        treeNode.prettyPrint();
        treeNode = subtreeWithAllDeepest(treeNode);
        treeNode.prettyPrint();

    }

    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root==null) {
            return null;
        }
        return null;

    }
    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public int depth(TreeNode root, int depth) {
        if (root==null) {
            return 0;
        }
        int left = depth(root.left, depth+1);
        int right = depth(root.right, depth+1);
        return Math.max(left, right);
    }
}
