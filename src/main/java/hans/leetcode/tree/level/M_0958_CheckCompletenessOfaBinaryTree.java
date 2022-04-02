package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given the root of a binary tree, determine if it is a complete binary tree.

 In a complete binary tree, every level, except possibly the last, is
 completely filled, and all nodes in the last level are as far left as possible. It can
 have between 1 and 2ʰ nodes inclusive at the last level h.


 Example 1:


 Input: root = [1,2,3,4,5,6]
 Output: true
 Explanation: Every level before the last is full (ie. levels with node-values {1
 } and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as
 possible.


 Example 2:


 Input: root = [1,2,3,4,5,null,7]
 Output: false
 Explanation: The node with value 7 isn't as far left as possible.



 Constraints:


 The number of nodes in the tree is in the range [1, 100].
 1 <= Node.val <= 1000

 Related Topics 树 广度优先搜索 二叉树 👍 187 👎 0

 */
public class M_0958_CheckCompletenessOfaBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1,2,3});
        treeNode1.prettyPrint();

        Logger.log(isCompleteTree(treeNode1));
        Logger.log(isCompleteTree2(treeNode1));

    }

    /**
     * 			Success:
     * 			Runtime:1 ms, faster than 69.93% of Java online submissions.
     * 			Memory Usage:40.6 MB, less than 56.98% of Java online submissions.
     * @param root
     * @return
     */
    public boolean isCompleteTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFindNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node!=null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
            // 所有元素连起来中间不能有空值，只要有空值，就不是完全二叉树
            isFindNull = isFindNull?isFindNull:node==null;
            if (isFindNull&&node!=null) {
                return false;
            }
        }
        return true;
    }
        /**
         * 			执行耗时:1 ms,击败了82.89% 的Java用户
         * 			内存消耗:37.8 MB,击败了52.21% 的Java用户
         * @param root
         * @return
         */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        int size;
        boolean findNull = false;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null) {
                    if (findNull) {
                        return false;
                    }
                    queue.offer(poll.left);
                } else {
                    findNull = true;
                }
                if (poll.right!=null) {
                    if (findNull) {
                        return false;
                    }
                    queue.offer(poll.right);
                } else {
                    findNull = true;
                }
            }

            if (!queue.isEmpty()&&size<levelSize) {
                return false;
            }
            levelSize*=2;
        }
        return true;
    }

}
