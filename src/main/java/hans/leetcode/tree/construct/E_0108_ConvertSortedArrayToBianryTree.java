package hans.leetcode.tree.construct;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-tree/
 */
public class E_0108_ConvertSortedArrayToBianryTree {

    @Test
    public void test() {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10,-3,0,5,9});

        treeNode.prettyPrint();
    }
    public TreeNode sortedArrayToBST(int[] nums) {
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
