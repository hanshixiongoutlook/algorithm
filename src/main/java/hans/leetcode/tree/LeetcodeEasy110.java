package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LeetcodeEasy108 {

    @Test
    public void test() {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10,-3,0,5,9});

        System.out.println(treeNode);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) {
            return null;
        }
        if (nums.length==1) {
            return new TreeNode(nums[0]);
        }
        return buildTree(nums, 0, nums.length-1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {

        if (start>end) {
            return null;
        }
        int half = (end+start)/2;
        TreeNode node = new TreeNode(nums[half]);
        node.left = buildTree(nums, start, half-1);
        node.right = buildTree(nums, half+1, end);
        return node;
    }
}
