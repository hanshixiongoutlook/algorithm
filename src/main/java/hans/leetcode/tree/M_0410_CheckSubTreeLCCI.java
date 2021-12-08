package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 Runtime:1 ms, faster than 83.25% of Java online submissions.
 Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
 */
public class M_0410_CheckSubTreeLCCI {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 0, 1, -4, -3});
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{1,-4});

        boolean b = checkSubTree(treeNode, treeNode2);
        Logger.log(b);
    }
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1==null) {
            return false;
        }
        boolean same = isSame(t1, t2);
        if (same) {
            return true;
        }
        return checkSubTree(t1.left, t2)||checkSubTree(t1.right, t2);
    }

    public boolean isSame(TreeNode t1, TreeNode t2) {
        if (t2==null) {
            return true;
        }
        if (t1==null&&t2!=null) {
            return false;
        }
        if (t1.val!=t2.val) {
            return false;
        }
        return isSame(t1.left, t2.left)&&isSame(t1.right, t2.right);
    }

}
