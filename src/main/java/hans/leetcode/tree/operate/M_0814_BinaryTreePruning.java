package hans.leetcode.tree.operate;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 Given the root of a binary tree, return the same tree where every subtree (of
 the given tree) not containing a 1 has been removed.

 A subtree of a node node is node plus every node that is a descendant of node.



 Example 1:


 Input: root = [1,null,0,0,1]
 Output: [1,null,0,null,1]
 Explanation:
 Only the red nodes satisfy the property "every subtree not containing a 1".
 The diagram on the right represents the answer.


 Example 2:


 Input: root = [1,0,1,0,0,0,1]
 Output: [1,null,1,null,1]


 Example 3:


 Input: root = [1,1,0,1,1,0,1,0]
 Output: [1,1,0,1,1,null,1]



 Constraints:


 The number of nodes in the tree is in the range [1, 200].
 Node.val is either 0 or 1.

 Related Topics 树 深度优先搜索 二叉树 👍 215 👎 0

 */
public class M_0814_BinaryTreePruning {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,0,0,0,0,1,0});
        treeNode.prettyPrint();
        treeNode = pruneTree(treeNode);
        treeNode.prettyPrint();

    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:36.1 MB, less than 19.07% of Java online submissions.
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root==null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 叶子节点
        if (root.left==null&&root.right==null) {
            if (root.val==0) {
                return null;
            }
        }
        return root;
    }
}
