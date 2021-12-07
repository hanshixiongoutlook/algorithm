package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 * 同剑指056
 */
public class M_0098_ValidateBinarySearchTree {

    @Test
    public void test() {
        // true 5,3,6,2,4,null,7       9
        // false 5,3,6,2,4,null,7     28
        TreeNode treeNode = TreeNode.buildSearchTree(new int[]{5,3,6,2,4,7});
        treeNode.prettyPrint();
        boolean mode = this.isValidBST(treeNode);
        Logger.log(mode);
    }

    /**
     * TODO important
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return false;
        }
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root==null) {
            return true;
        }
        if (min!=null&&root.val<=min.val) return false;
        if (max!=null&&root.val>=max.val) return false;
        return isValidBST(root.left, min, root)&&isValidBST(root.right, root, max);
    }

}
