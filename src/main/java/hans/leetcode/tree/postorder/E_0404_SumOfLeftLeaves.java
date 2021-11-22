package hans.leetcode.tree.postorder;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class E_0404_SumOfLeftLeaves {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,4,5,6,7,8,9,});
        treeNode.prettyPrint();
        System.out.println(this.sumOfLeftLeaves(treeNode));
    }

    /**
     * TODO
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        if (root.left!=null&&root.left.left==null&&root.left.right==null) {
            return left+right+root.left.val;
        }
        return left+right+0;
    }


}
