package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 同783
 */
public class M_1382_BalanceABinarySearchTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,null,2,null,3,null,4,null,null});
        treeNode.prettyPrint();
        TreeNode mode = this.balanceBST(treeNode);
        mode.prettyPrint();
    }
    List<Integer> list;

    /**
     * 			Runtime:2 ms, faster than 98.58% of Java online submissions.
     * 			Memory Usage:42 MB, less than 13.88% of Java online submissions.
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        return sortedArrayToBST(list, 0, list.size()-1);
    }
    public void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    public TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if (start>end) {
            return null;
        }
        TreeNode root = new TreeNode(nums.get((end-start)/2+start));
        root.left = sortedArrayToBST(nums, start, (end-start)/2+start-1);
        root.right = sortedArrayToBST(nums, (end-start)/2+start+1, end);
        return root;
    }
}
