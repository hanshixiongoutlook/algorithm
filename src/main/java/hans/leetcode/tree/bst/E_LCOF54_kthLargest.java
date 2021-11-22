package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 * 同783
 */
public class E_LCOF54_kthLargest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,1,4,null,2});
        treeNode.prettyPrint();
        int mode = this.kthLargest(treeNode, 1);
        Logger.log(mode);
    }
    int sort=0;
    int result = -1;
    public int kthLargest(TreeNode root, int k) {
        if (root==null) {
            return result;
        }
        kthLargest(root.right, k);
        sort++;
        if (sort==k) {
            result = root.val;
        }
        kthLargest(root.left, k);
        return result;
    }
}
