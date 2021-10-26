package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class EasyLCOF0068_lowestCommonAncestor2 {

    @Test
    public void test() {
//        1,2,2,3,3,null,null,4,4
        // 3,9,20,null,null,15,7
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        treeNode.prettyPrint();

        TreeNode result = this.lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(4));
        Logger.log(result.val);
    }

    TreeNode ancestor = null;
    boolean pFind = false;
    boolean qFind = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        isAncestor(root, p, q);
        if (pFind&&qFind) {
            ancestor = root;
        }
        pFind=false;
        qFind=false;
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        return ancestor;
    }

    public void isAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return;
        }
        if (root.val==p.val) {
            pFind = true;
        }
        if (root.val==q.val) {
            qFind = true;
        }
        isAncestor(root.left, p, q);
        isAncestor(root.right, p, q);
    }
}
