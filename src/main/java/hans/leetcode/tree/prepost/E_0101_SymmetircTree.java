package hans.leetcode.tree.prepost;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 同 剑指28
 */
public class E_0101_SymmetircTree {
    @Test
    public void test() {
        TreeNode tree1 = TreeNode.buildTree(new Integer[]{1,null,2,null,null,4,3});
        tree1.prettyPrint();
        tree1.arrayPrint();
        boolean treeNode = isSymmetric(tree1);

        System.out.println(treeNode);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }

    private boolean isSymmetricChild(TreeNode left, TreeNode right) {
        if (left==null||right==null) {
            return left==right;
        }
        if (left.val!=right.val) {
            return false;
        }
        return isSymmetricChild(left.left, right.right)&&isSymmetricChild(left.right, right.left);
    }
}
