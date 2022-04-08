package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能的答
 案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3
 9        /   /      -10  5 Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 121 👎 0

 */
public class E_LCCI0402_MinimumHeightTree {

    @Test
    public void test() {
        TreeNode mode = this.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9});
        mode.prettyPrint();
        mode.arrayPrint();
    }

    /**
     * 分治法
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start>end) {
            return null;
        }
        TreeNode root = new TreeNode(nums[(end-start)/2+start]);
        root.left = sortedArrayToBST(nums, start, (end-start)/2+start-1);
        root.right = sortedArrayToBST(nums, (end-start)/2+start+1, end);
        return root;
    }
}
