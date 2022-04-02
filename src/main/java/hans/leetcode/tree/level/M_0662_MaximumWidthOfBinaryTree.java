package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 Given the root of a binary tree, return the maximum width of the given tree.

 The maximum width of a tree is the maximum width among all levels.

 The width of one level is defined as the length between the end-nodes (the
 leftmost and rightmost non-null nodes), where the null nodes between the end-nodes
 that would be present in a complete binary tree extending down to that level are
 also counted into the length calculation.

 It is guaranteed that the answer will in the range of a 32-bit signed integer.



 Example 1:


 Input: root = [1,3,2,5,3,null,9]
 Output: 4
 Explanation: The maximum width exists in the third level with length 4 (5,3,
 null,9).


 Example 2:


 Input: root = [1,3,2,5,null,null,9,6,null,7]
 Output: 7
 Explanation: The maximum width exists in the fourth level with length 7 (6,null,
 null,null,null,null,7).


 Example 3:


 Input: root = [1,3,2,5]
 Output: 2
 Explanation: The maximum width exists in the second level with length 2 (3,2).



 Constraints:


 The number of nodes in the tree is in the range [1, 3000].
 -100 <= Node.val <= 100

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 325 👎 0

 */
public class M_0662_MaximumWidthOfBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,null,3,4,5,6,8,9});
        treeNode.prettyPrint();
        Logger.log(widthOfBinaryTree(treeNode));
    }

    /**
     * 			Runtime:3 ms, faster than 7.50% of Java online submissions.
     * 			Memory Usage:38.1 MB, less than 69.97% of Java online submissions.
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 1;
        Map<TreeNode, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start=0,end=0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i==0) {
                    start=map.getOrDefault(node, 0);
                }
                if (i==(size-1)) {
                    end=map.getOrDefault(node,0);
                }
                if (node.left!=null) {
                    map.put(node.left, 2*map.getOrDefault(node,0)+1);
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    map.put(node.right, 2*map.getOrDefault(node,0)+2);
                    queue.offer(node.right);
                }
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }

}
