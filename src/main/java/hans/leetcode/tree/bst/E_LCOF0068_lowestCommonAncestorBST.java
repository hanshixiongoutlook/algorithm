package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;


/**
 * 同 235
 */
public class E_LCOF0068_lowestCommonAncestorBST {

    @Test
    public void test() {
//        1,2,2,3,3,null,null,4,4
        // 3,9,20,null,null,15,7
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,2,7,1,3,6,8,null,null,null,4,null,null,null,9});
        treeNode.prettyPrint();

        TreeNode result = this.lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(4));
        Logger.log(result.val);
    }

    TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        if (p.val<q.val) {
            if (root.val>=p.val && root.val<=q.val) {
                ancestor = root;
            }
        } else {
            if (root.val<=p.val && root.val>=q.val) {
                ancestor = root;
            }
        }
        if (root.val>p.val && root.val>q.val) {
            lowestCommonAncestor(root.left, p, q);
        } else if (root.val<p.val && root.val<q.val) {
            lowestCommonAncestor(root.right, p, q);
        }
        return ancestor;
    }

}
