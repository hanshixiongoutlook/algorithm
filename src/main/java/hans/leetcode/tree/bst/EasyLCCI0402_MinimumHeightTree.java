package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * 同783
 */
public class EasyLCCI0402_MinimumHeightTree {

    @Test
    public void test() {
        TreeNode mode = this.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9});
        mode.prettyPrint();
        mode.arrayPrint();
    }

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
