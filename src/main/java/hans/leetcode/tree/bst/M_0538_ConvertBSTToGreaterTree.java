package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 同783
 */
public class M_0538_ConvertBSTToGreaterTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildSearchTree(new int[]{3,1,4,5,2});
        treeNode.prettyPrint();
        convertBST(treeNode);
        treeNode.prettyPrint();
//        TreeNode mode = this.convertBST(treeNode);
//        treeNode.prettyPrint();
    }

    TreeNode pre = null;

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.4 MB,击败了86.21% 的Java用户
     */
    public TreeNode convertBST(TreeNode root) {
        if (root==null) {
            return root;
        }
        convertBST(root.right);
        if (pre!=null) {
            root.val = pre.val+ root.val;
        }
        pre = root;
        convertBST(root.left);
        return root;
    }

}
