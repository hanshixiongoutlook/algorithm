package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;


public class E_0671_SecondMinimumNodeInBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2,2,5,null,null,5,7});
        treeNode.prettyPrint();
        int result = this.findSecondMinimumValue(treeNode);
        // [3.00000,14.50000,11.00000]
        Logger.log(result);
    }
    int min=-1;
    int second=-1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root==null) {
            return second;
        }

        if (min==-1||root.val<min) {
            min = root.val;
        }
        if (root.val>min) {
            if (second==-1||root.val<second) {
                second = root.val;
            }
        }
        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
        return second;
    }

}
