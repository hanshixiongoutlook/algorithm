package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import org.junit.Test;
/**
 Given the root of a binary tree, flatten the tree into a "linked list":


 The "linked list" should use the same TreeNode class where the right child
 pointer points to the next node in the list and the left child pointer is always
 null.
 The "linked list" should be in the same order as a pre-order traversal of the
 binary tree.



 Example 1:


 Input: root = [1,2,5,3,4,null,6]
 Output: [1,null,2,null,3,null,4,null,5,null,6]


 Example 2:


 Input: root = []
 Output: []


 Example 3:


 Input: root = [0]
 Output: [0]



 Constraints:


 The number of nodes in the tree is in the range [0, 2000].
 -100 <= Node.val <= 100



 Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related
 Topics 栈 树 深度优先搜索 链表 二叉树 👍 1130 👎 0

 */
public class M_0114_FlattenBinaryTreeToLinkedList {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5});
        treeNode.prettyPrint();
        flatten(treeNode);
        treeNode.prettyPrint();
    }
    TreeNode pre;
    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:37.8 MB, less than 50.68% of Java online submissions.
     */
    public void flatten(TreeNode root) {
        if (root==null) {
            return;
        }
        if (pre!=null) {
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
    }

}
