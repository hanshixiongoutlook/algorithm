package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 Given the root of a binary tree, return the length of the diameter of the tree.


 The diameter of a binary tree is the length of the longest path between any
 two nodes in a tree. This path may or may not pass through the root.

 The length of a path between two nodes is represented by the number of edges
 between them.


 Example 1:


 Input: root = [1,2,3,4,5]
 Output: 3
 Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].


 Example 2:


 Input: root = [1,2]
 Output: 1



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁴].
 -100 <= Node.val <= 100

 Related Topics 树 深度优先搜索 二叉树 👍 978 👎 0

 */
public class E_0543_DiameterOfBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7,8,9});
//
        System.out.println(this.diameterOfBinaryTree(treeNode));
    }
    int max;

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:40.9 MB,击败了56.64% 的Java用户
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        max=1;
        if (root==null) {
            return 0;
        }
        diameterOfBinaryTreeDepth(root);
        return max-1;
    }
    public int diameterOfBinaryTreeDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftDepth = this.diameterOfBinaryTreeDepth(root.left);
        int rightDepth = this.diameterOfBinaryTreeDepth(root.right);
        max = Math.max(max, leftDepth+rightDepth+1);
        return Math.max(leftDepth,rightDepth)+1;
    }

}
