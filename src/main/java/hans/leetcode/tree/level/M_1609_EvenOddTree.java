package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 A binary tree is named Even-Odd if it meets the following conditions:


 The root of the binary tree is at level index 0, its children are at level
 index 1, their children are at level index 2, etc.
 For every even-indexed level, all nodes at the level have odd integer values
 in strictly increasing order (from left to right).
 For every odd-indexed level, all nodes at the level have even integer values
 in strictly decreasing order (from left to right).


 Given the root of a binary tree, return true if the binary tree is Even-Odd,
 otherwise return false.


 Example 1:


 Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 Output: true
 Explanation: The node values on each level are:
 Level 0: [1]
 Level 1: [10,4]
 Level 2: [3,7,9]
 Level 3: [12,8,6,2]
 Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all even
 and decreasing, the tree is Even-Odd.


 Example 2:


 Input: root = [5,4,2,3,3,7]
 Output: false
 Explanation: The node values on each level are:
 Level 0: [5]
 Level 1: [4,2]
 Level 2: [3,3,7]
 Node values in level 2 must be in strictly increasing order, so the tree is not
 Even-Odd.


 Example 3:


 Input: root = [5,9,1,3,5,7]
 Output: false
 Explanation: Node values in the level 1 should be even integers.



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁵].
 1 <= Node.val <= 10⁶

 Related Topics 树 广度优先搜索 二叉树 👍 71 👎 0

 */
public class M_1609_EvenOddTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{13,34,32,23,25,27,29,44,40,36,34,30,30,28,26,3,7,9,11,15,17,21,25,null,null,27,31,35,null,37,null,30,null,26,null,null,null,24,null,20,16,12,10,null,null,8,null,null,null,null,null,6,null,null,null,null,null,15,19,null,null,null,null,23,null,27,29,33,37,null,null,null,null,null,null,48,null,null,null,46,null,null,null,42,38,34,32,null,null,null,null,19});
//        treeNode.prettyPrint();
        Logger.log(isEvenOddTree(treeNode));
        Logger.log(isEvenOddTree2(treeNode));

    }

    /**
     * 			执行耗时:10 ms,击败了46.27% 的Java用户
     * 			内存消耗:55.5 MB,击败了22.91% 的Java用户
     * @param root
     * @return
     */
    public boolean isEvenOddTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int level = 1;
        // 当前是奇数层
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean increasing = level%2==1;
            int pre = queue.peek().val;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
                // 奇数层只有奇数；偶数层只有偶数
                if ((increasing&&node.val%2==0)||(!increasing&&node.val%2==1)) {
                    return false;
                }
                // 奇数层升序；偶数层降序
                if (i!=0 && ((increasing&&pre>=node.val) || (!increasing&&pre<=node.val))) {
                    return false;
                }
                pre = node.val;
            }
            level++;
        }
        return true;
    }
        /**
         Runtime:1 ms, faster than 83.25% of Java online submissions.
         Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
         */
    public boolean isEvenOddTree(TreeNode root) {
        if (root==null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        // 当前是奇数层
        boolean isOddlevel = false;
        while (!queue.isEmpty()) {
            TreeNode pre = queue.poll();
            if ((isOddlevel&&pre.val%2==1)||(!isOddlevel&&pre.val%2==0)) {
                return false;
            }
            int size = queue.size();
            if (pre.left!=null) {
                queue.offer(pre.left);
            }
            if (pre.right!=null) {
                queue.offer(pre.right);
            }
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (isOddlevel) {
                    if (node.val%2==1||node.val>=pre.val) {
                        return false;
                    }
                } else {
                    if (node.val%2==0||node.val<=pre.val) {
                        return false;
                    }
                }
                pre = node;
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            isOddlevel = !isOddlevel;
        }
        return true;
    }

}
