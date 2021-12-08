package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class M_0406_Successor {

    @Test
    public void test() {
//        1,null,10,-5,20
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,3,6,2,4,null,null,1});
        treeNode.prettyPrint();
        TreeNode treeNode1 = inorderSuccessor(treeNode, new TreeNode(5));
        treeNode1.prettyPrint();
    }
    TreeNode next = null;
    boolean findP = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root==null) {
            return null;
        }
        inorderSuccessor(root.left, p);
        if (findP&&next==null) {
            next = root;
        }
        if (root.val==p.val) {
            findP=true;
        }
        inorderSuccessor(root.right, p);
        return next;
    }


}
