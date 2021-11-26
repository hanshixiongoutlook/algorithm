package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 */
public class M_0814_BinaryTreePruning {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,0,0,0,0,1,0});
        treeNode.prettyPrint();
        treeNode = pruneTree(treeNode);
        treeNode.prettyPrint();

    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:36.1 MB, less than 19.07% of Java online submissions.
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root==null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 叶子节点
        if (root.left==null&&root.right==null) {
            if (root.val==0) {
                return null;
            }
        }
        return root;
    }
}
