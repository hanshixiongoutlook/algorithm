package hans.leetcode.tree.binary;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

/**
 Runtime:1 ms, faster than 83.25% of Java online submissions.
 Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
 */
public class Medium0337_HouseRobber {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,5,4,6,7,8});
        treeNode.prettyPrint();
//        Logger.log2Json(rob(treeNode));

    }

    public int rob(TreeNode root, boolean isCalcParent, int sum) {
        if (root==null) {
            return 0;
        }
        if (isCalcParent) {
            rob(root.left, false, sum);
            rob(root.right, false, sum);
        } else {
            rob(root.left, true, sum+root.val);
            rob(root.right, true, sum+root.val);
            rob(root.left, false, sum);
            rob(root.right, false, sum);
        }
        return sum;



    }

}
