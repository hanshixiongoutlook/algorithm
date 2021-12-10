package hans.leetcode.tree.construct;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 *
 */
public class M_0654_MaximumBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = constructMaximumBinaryTree(new int[]{3,2,1});
        treeNode.prettyPrint();

    }


    /**
     * 			Runtime:3 ms, faster than 15.37% of Java online submissions.
     * 			Memory Usage:38.4 MB, less than 79.12% of Java online submissions.
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums==null||nums.length==0) {
            return null;
        }
        int maxIdx = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]>nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
        if ((maxIdx+1)<nums.length) {
            node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx+1, nums.length));
        }
        return node;
    }

}
