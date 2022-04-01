package hans.leetcode.tree.easy;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 Given the roots of two binary trees p and q, write a function to check if they
 are the same or not.

 Two binary trees are considered the same if they are structurally identical,
 and the nodes have the same value.


 Example 1:


 Input: p = [1,2,3], q = [1,2,3]
 Output: true


 Example 2:


 Input: p = [1,2], q = [1,null,2]
 Output: false


 Example 3:


 Input: p = [1,2,1], q = [1,1,2]
 Output: false



 Constraints:


 The number of nodes in both trees is in the range [0, 100].
 -10⁴ <= Node.val <= 10⁴

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 779 👎 0

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
        if (p==null||q==null) {
            return p==q;
        }
        if (p.val!=q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
