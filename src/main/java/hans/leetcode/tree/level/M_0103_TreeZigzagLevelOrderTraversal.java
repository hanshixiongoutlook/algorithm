package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 Given the root of a binary tree, return the zigzag level order traversal of its
 nodes' values. (i.e., from left to right, then right to left for the next level
 and alternate between).


 Example 1:


 Input: root = [3,9,20,null,null,15,7]
 Output: [[3],[20,9],[15,7]]


 Example 2:


 Input: root = [1]
 Output: [[1]]


 Example 3:


 Input: root = []
 Output: []



 Constraints:


 The number of nodes in the tree is in the range [0, 2000].
 -100 <= Node.val <= 100

 Related Topics 树 广度优先搜索 二叉树 👍 613 👎 0

 */
public class M_0103_TreeZigzagLevelOrderTraversal {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,9,20,null,null,15,7});
        treeNode.prettyPrint();
        Logger.log(zigzagLevelOrder(treeNode));

    }

    /**
     * 			Runtime:1 ms, faster than 77.94% of Java online submissions.
     * 			Memory Usage:41.1 MB, less than 10.58% of Java online submissions.
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftFirst = true;
        List<List<Integer>> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.remove();
                if (isLeftFirst) {
                    levelList.add(node.val);
                } else {
                    levelList.add(0,node.val);
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            isLeftFirst = !isLeftFirst;
            if (levelList.size()>0) {
                result.add(levelList);
            }
        }
        return result;
    }

}
