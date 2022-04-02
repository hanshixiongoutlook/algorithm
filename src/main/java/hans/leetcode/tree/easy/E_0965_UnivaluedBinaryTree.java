package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Objects;


public class E_0965_UnivaluedBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,2,2,2,2});
        treeNode.prettyPrint();
        boolean result2 = this.isUnivalTree(treeNode);

        // [3.00000,14.50000,11.00000]
        Logger.log(result2);
    }

    Integer standard;

    /**
     * 		Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:39.1 MB, less than 18.99% of Java online submissions.
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root==null) {
            return true;
        }
        if (standard==null) {
            standard=root.val;
        }
        if (!Objects.equals(root.val,standard)) {
            return false;
        }
        return isUnivalTree(root.left)&& isUnivalTree(root.right);
    }


}
