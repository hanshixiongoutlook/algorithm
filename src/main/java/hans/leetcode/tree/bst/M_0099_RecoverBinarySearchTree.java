package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 内存消耗大
 */
public class M_0099_RecoverBinarySearchTree {

    @Test
    public void test() {
        TreeNode build = TreeNode.buildTree(new Integer[]{3,1,4,null,null,2});
        build.prettyPrint();
        build.inoderPrint();
        this.recoverTree(build);
        build.prettyPrint();
        build.inoderPrint();
    }

    /**
     * 321
     * 123
     * 1 2 3 4 5
     * 3 1 2 4 5
     * 1 5 3 4 2
     * 1 3 2 4 5
     * 5 2 3 4 1
     * @param root
     */
    TreeNode[] less = new TreeNode[2];
    List<TreeNode> all = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        recoverTree(root, null);
        if (less[0]==null) {
            return;
        }
        TreeNode errorNode = less[0];
        if (less[1]!=null) {
            errorNode=less[1];
        }
        for (TreeNode n: all) {
            if (n.val>errorNode.val) {
                int temp = errorNode.val;
                errorNode.val = n.val;
                n.val = temp;
                break;
            }
        }
    }
    public void recoverTree(TreeNode root, TreeNode preNode) {
        if (root==null) {
            return;
        }
        recoverTree(root.left, root);
        if (all.size()>0) {
            preNode = all.get(all.size()-1);
        }
        if (preNode!=null && root.val<preNode.val) {
            if (less[0]==null) {
                less[0]=root;
            } else {
                less[1]=root;
            }
        }
        all.add(root);

        recoverTree(root.right, root);
    }
}
