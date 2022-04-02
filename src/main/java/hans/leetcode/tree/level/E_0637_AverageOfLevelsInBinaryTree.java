package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Given the root of a binary tree, return the average value of the nodes on each
 level in the form of an array. Answers within 10⁻⁵ of the actual answer will be
 accepted.

 Example 1:


 Input: root = [3,9,20,null,null,15,7]
 Output: [3.00000,14.50000,11.00000]
 Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
 and on level 2 is 11.
 Hence return [3, 14.5, 11].


 Example 2:


 Input: root = [3,9,20,15,7]
 Output: [3.00000,14.50000,11.00000]



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁴].
 -2³¹ <= Node.val <= 2³¹ - 1

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 321 👎 0

 */
public class E_0637_AverageOfLevelsInBinaryTree {

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
