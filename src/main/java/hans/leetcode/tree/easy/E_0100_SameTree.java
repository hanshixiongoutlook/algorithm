package hans.leetcode.tree.easy;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class E_0100_SameTree {
    @Test
    public void test() {
        TreeNode tree1 = TreeNode.buildTree(new Integer[]{1, 2, 3});
        TreeNode tree2 = TreeNode.buildTree(new Integer[]{1, 2, 4});
        boolean treeNode = isSameTree(tree1, tree2);

        System.out.println(treeNode);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&p==q) return true;
        if ((p==null||q==null)&&p!=q) {
            return false;
        }
        if (p.val!=q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
