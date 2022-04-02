package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 Given the root of a binary tree, imagine yourself standing on the right side of
 it, return the values of the nodes you can see ordered from top to bottom.


 Example 1:


 Input: root = [1,2,3,null,5,null,4]
 Output: [1,3,4]


 Example 2:


 Input: root = [1,null,3]
 Output: [1,3]


 Example 3:


 Input: root = []
 Output: []



 Constraints:


 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 653 👎 0

 */
public class M_0199_BinaryTreeRightSideView {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,5,4});
        treeNode.prettyPrint();
        Logger.log(rightSideView(treeNode));

    }
    /**
     Runtime:1 ms, faster than 83.25% of Java online submissions.
     Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root==null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i==size-1) {
                    list.add(node.val);
                }
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }

}
