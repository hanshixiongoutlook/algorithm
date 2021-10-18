package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 1
 * 2 3
 * 4 5 n n
 * 6
 */
public class Easy0111_MinimumDepthOfBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5, null, null, 6});
//
        System.out.println(this.minDepth(treeNode));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root, 0);
    }

    public int minDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth + 1;
        }
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if (root.left != null) {
            left = minDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            right = minDepth(root.right, depth + 1);
        }
        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) {
            return Math.min(left, right);
        }
        if (left == Integer.MIN_VALUE) {
            return right;
        }
        if (right == Integer.MIN_VALUE) {
            return left;
        }
        return depth + 1;
    }
}
