package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Easy0671_SecondMinimumNodeInBinaryTree {

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
