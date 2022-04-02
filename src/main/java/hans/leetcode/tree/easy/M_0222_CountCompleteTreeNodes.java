package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 Given the root of a complete binary tree, return the number of the nodes in the
 tree.

 According to Wikipedia, every level, except possibly the last, is completely
 filled in a complete binary tree, and all nodes in the last level are as far left
 as possible. It can have between 1 and 2ʰ nodes inclusive at the last level h.

 Design an algorithm that runs in less than O(n) time complexity.


 Example 1:


 Input: root = [1,2,3,4,5,6]
 Output: 6


 Example 2:


 Input: root = []
 Output: 0


 Example 3:


 Input: root = [1]
 Output: 1



 Constraints:


 The number of nodes in the tree is in the range [0, 5 * 10⁴].
 0 <= Node.val <= 5 * 10⁴
 The tree is guaranteed to be complete.

 Related Topics 树 深度优先搜索 二分查找 二叉树 👍 653 👎 0

 */
public class M_0222_CountCompleteTreeNodes {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,5,4,6,7,8});
        treeNode.prettyPrint();
        Logger.log(countNodes(treeNode));

    }

    int count=0;
    /**
     Runtime:1 ms, faster than 83.25% of Java online submissions.
     Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
     */
    public int countNodes(TreeNode root) {
        if (root==null) {
            return count;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

}
