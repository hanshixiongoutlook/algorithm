package hans.leetcode.tree.easy;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
 symmetric around its center).


 Example 1:


 Input: root = [1,2,2,3,4,4,3]
 Output: true


 Example 2:


 Input: root = [1,2,2,null,3,null,3]
 Output: false



 Constraints:


 The number of nodes in the tree is in the range [1, 1000].
 -100 <= Node.val <= 100



 Follow up: Could you solve it both recursively and iteratively? Related Topics 树
 深度优先搜索 广度优先搜索 二叉树 👍 1814 👎 0

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
