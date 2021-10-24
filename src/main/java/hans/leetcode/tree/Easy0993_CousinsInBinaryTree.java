package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;


public class Easy0993_CousinsInBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        treeNode.prettyPrint();
        boolean result = this.isCousins(treeNode, 8, 15);
        // [3.00000,14.50000,11.00000]
        Logger.log(result);
    }

    int xDepth = -1;
    int yDepth = -1;
    TreeNode xParent = null;
    TreeNode yParent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.find(root, null, 0, x, y);
        if (xDepth==-1&&yDepth==-1) {
            return false;
        }
        if (xParent==null||yParent==null) {
            return false;
        }
        return xDepth==yDepth && xParent.val!=yParent.val;
    }

    public void find(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null) {
            return;
        }
        if (x==root.val) {
            xDepth=depth;
            xParent = parent;
        }
        if (y==root.val) {
            yDepth=depth;
            yParent = parent;
        }
        if (xDepth!=-1&&yDepth!=-1) {
            return;
        }

        find(root.left, root, depth+1, x, y);
        find(root.right, root, depth+1, x, y);
    }


}
