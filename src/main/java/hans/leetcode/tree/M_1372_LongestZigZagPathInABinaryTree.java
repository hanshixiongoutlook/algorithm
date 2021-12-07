package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class M_1372_LongestZigZagPathInABinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,1,1,null,1,null,null,1,1,null,1});
        int i = longestZigZag(treeNode);
        treeNode.prettyPrint();
        Logger.log(i);
    }
    int max=0;

    /**
     * 			Runtime:50 ms, faster than 8.54% of Java online submissions.
     * 			Memory Usage:52.4 MB, less than 7.83% of Java online submissions.
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max;
    }
    public void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        int left = zigZag(root, true);
        int right = zigZag(root, false);
        int nodeMax = Math.max(left, right);
        lmap.put(root, left);
        rmap.put(root, right);
        max = Math.max(max, nodeMax);
    }
    Map<TreeNode, Integer> lmap = new HashMap<>();
    Map<TreeNode, Integer> rmap = new HashMap<>();

    public int zigZag(TreeNode root, boolean isLeft) {
        int count = 0;
        TreeNode next = root;
        boolean curLeft = isLeft;
        while (next!=null) {

            if (curLeft) {
                if (lmap.containsKey(next)) {
                    return lmap.get(next)+count;
                }
                if (next.left!=null) {
                    count++;
                    curLeft = false;
                }
                next = next.left;
            } else {
                if (rmap.containsKey(next)) {
                    return rmap.get(next)+count;
                }
                if (next.right!=null) {
                    count++;
                    curLeft = true;
                }
                next = next.right;
            }
        }
        return count;
    }

}
