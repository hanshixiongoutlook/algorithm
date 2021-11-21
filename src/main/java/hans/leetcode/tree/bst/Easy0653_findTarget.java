package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 * 同剑指056
 */
public class Easy0653_findTarget {

    @Test
    public void test() {
        // true 5,3,6,2,4,null,7       9
        // false 5,3,6,2,4,null,7     28
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,3,6,2,4,null,7});
        treeNode.prettyPrint();
        boolean mode = this.findTarget(treeNode, 13);
        Logger.log(mode);
    }
    TreeNode base = null;
    public boolean findTarget(TreeNode root, int k) {
        if (root==null) {
            return false;
        }
        if (base==null) {
            base = root;
        }
        boolean left = false;
        boolean right = false;
        int diff = k-root.val;
        if (root.val>diff&&diff!=root.val) {
            left = findNode(base, diff);
        } else if (root.val<diff&&diff!=root.val){
            right = findNode(base, diff);
        }
        if (left||right) {
            return true;
        }
        if (root.val>k) {
            left = findTarget(root.left, k);
        } else {
            left = findTarget(root.left, k);
            right = findTarget(root.right, k);
        }
        return left||right;
    }

    public boolean findNode(TreeNode root, int target) {
        if (root==null) {
            return false;
        }
        if (root.val==target) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (root.val>target) {
            left = findNode(root.left, target);
        } else {
            right = findNode(root.right, target);
        }
        return left||right;
    }


}
