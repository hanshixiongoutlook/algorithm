package hans.leetcode.tree.binary;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Easy0637_AverageOfLevelsInBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,9,20,15,7});
        treeNode.prettyPrint();
        System.out.println(treeNode.depth());
        List<Double> result = this.averageOfLevels(treeNode);
        // [3.00000,14.50000,11.00000]
        Logger.log(result);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Double sum = 0.0;
            int sizeOfLayer = queue.size();
            for (int i=0; i<sizeOfLayer; i++) {
                TreeNode node = queue.remove();
                sum+=node.val;
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            list.add(Double.valueOf(sum)/sizeOfLayer);
        }
        return list;
    }

}
