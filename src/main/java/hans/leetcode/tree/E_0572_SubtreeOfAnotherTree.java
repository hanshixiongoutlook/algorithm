package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;


public class E_0572_SubtreeOfAnotherTree {

    /**
     * TODO Time Complexity can be more optimized
     */
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,4,5,1,2});
        TreeNode subTree = TreeNode.buildTree(new Integer[]{4,1,2});

//
        System.out.println(this.isSubtree(treeNode, subTree));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot)) {
            return true;
        }
        if (root!=null) {
            boolean l = isSubtree(root.left, subRoot);
            boolean r= isSubtree(root.right, subRoot);
            return l||r;
        }
        return false;
    }

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root==null||subRoot==null) {
            return root==subRoot;
        }
        if (root.val!=subRoot.val) {
            return false;
        }
        boolean l = isSame(root.left, subRoot.left);
        boolean r = isSame(root.right, subRoot.right);

        return l&&r;

    }

}
