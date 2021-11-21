package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;


public class Easy0700_SearchInABST {

    @Test
    public void test() {
        // true 5,3,6,2,4,null,7       9
        // false 5,3,6,2,4,null,7     28
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{4,2,7,1,3});
        treeNode.prettyPrint();
        TreeNode mode = this.searchBST(treeNode, 11);
        mode.prettyPrint();
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) {
            return null;
        }
        if (root.val==val) {
            return root;
        }
        if (root.val>val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }


}
