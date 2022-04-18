package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * 和538相同，累加树
 */
public class M_1038_BinarySearchTreeToGreaterSumTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        treeNode1.prettyPrint();

        TreeNode i = bstToGst(treeNode1);

        i.prettyPrint();

    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.9 MB, less than 59.63% of Java online submissions.
     * @param root
     * @return
     */
    TreeNode pre = null;
    public TreeNode bstToGst(TreeNode root) {

        if (root==null) {
            return root;
        }
        bstToGst(root.right);
        if (pre!=null) {
            root.val = pre.val+ root.val;
        }
        pre = root;
        bstToGst(root.left);
        return root;
    }


}
