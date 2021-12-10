package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 */
public class M_0998_MaximumBinaryTree2 {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{5,2,4,null,1});
        treeNode1.prettyPrint();

        Logger.log("insert 3");
        TreeNode treeNode = insertIntoMaxTree(treeNode1, 3);
        treeNode.prettyPrint();
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.1 MB,击败了89.22% 的Java用户
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root==null||root.val<val) {
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
