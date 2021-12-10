package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 1
 * 2 3
 * 4 5 n n
 * 6
 */
public class E_0111_MinimumDepthOfBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5, null, null, 6});

        treeNode.prettyPrint();
        System.out.println(this.minDepth(treeNode));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
    }
}
