package hans.leetcode.tree.path;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 Given the root of a binary tree, find the maximum value v for which there exist
 different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

 A node a is an ancestor of b if either: any child of a is equal to b or any
 child of a is an ancestor of b.


 Example 1:


 Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 Output: 7
 Explanation: We have various ancestor-node differences, some of which are given
 below :
 |8 - 3| = 5
 |3 - 7| = 4
 |8 - 1| = 7
 |10 - 13| = 3
 Among all possible differences, the maximum value of 7 is obtained by |8 - 1| =
 7.

 Example 2:


 Input: root = [1,null,2,null,0,3]
 Output: 3



 Constraints:


 The number of nodes in the tree is in the range [2, 5000].
 0 <= Node.val <= 10⁵

 Related Topics 树 深度优先搜索 二叉树 👍 113 👎 0

 */
public class M_1026_MaximumDifferenceBetweenNodeAndAncestor {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{2,4,3,1,null,0,5,null,6,null,null,null,7});
        treeNode1.prettyPrint();

        int i = maxAncestorDiff(treeNode1);

        Logger.log(i);

    }

    /**
     Runtime:85 ms, faster than 15.38% of Java online submissions.
     Memory Usage:126.6 MB, less than 5.13% of Java online submissions.
     */
    int max = -1;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,new LinkedList<>());
        return max;
    }
    public void dfs(TreeNode root, Deque<Integer> deque) {
        if (root==null) {
            return;
        }
        for (int i: deque) {
            int diff = Math.abs(i-root.val);
            max = Math.max(max, diff);
        }
        deque.offer(root.val);
        dfs(root.left, deque);
        dfs(root.right, deque);
        deque.removeLast();
    }
}
