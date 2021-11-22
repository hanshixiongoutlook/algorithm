package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 * 同783
 */
public class M_0230_kthSmallestElementInaBST {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,1,4,null,2});
        treeNode.prettyPrint();
        int mode = this.kthSmallest(treeNode, 2);
        Logger.log(mode);
    }
    int sort=0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) {
            return result;
        }
        kthSmallest(root.left, k);
        sort++;
        if (sort==k) {
            result = root.val;
        }
        kthSmallest(root.right, k);
        return result;
    }

}
