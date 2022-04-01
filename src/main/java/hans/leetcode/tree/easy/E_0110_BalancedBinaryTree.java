package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:


 a binary tree in which the left and right subtrees of every node differ in
 height by no more than 1.



 Example 1:


 Input: root = [3,9,20,null,null,15,7]
 Output: true


 Example 2:


 Input: root = [1,2,2,3,3,null,null,4,4]
 Output: false


 Example 3:


 Input: root = []
 Output: true



 Constraints:


 The number of nodes in the tree is in the range [0, 5000].
 -10⁴ <= Node.val <= 10⁴

 Related Topics 树 深度优先搜索 二叉树 👍 932 👎 0

 */
public class E_0110_BalancedBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,2,3,3,3,null,4,4});
        treeNode.prettyPrint();
        System.out.println(this.isBalanced(treeNode));
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        int leftL = this.depth(root.left, 0);
        int rightL = this.depth(root.right, 0);
        if (Math.abs(leftL-rightL)>1) {
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left&&right;
    }

    public int depth(TreeNode root, int depth) {
        if (root==null) {
            return depth;
        }
        return Math.max(depth(root.left, depth+1), depth(root.right, depth+1));
    }
}
