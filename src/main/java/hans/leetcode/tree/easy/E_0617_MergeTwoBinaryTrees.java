package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 You are given two binary trees root1 and root2.

 Imagine that when you put one of them to cover the other, some nodes of the
 two trees are overlapped while the others are not. You need to merge the two trees
 into a new binary tree. The merge rule is that if two nodes overlap, then sum
 node values up as the new value of the merged node. Otherwise, the NOT null node
 will be used as the node of the new tree.

 Return the merged tree.

 Note: The merging process must start from the root nodes of both trees.


 Example 1:


 Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 Output: [3,4,5,5,4,null,7]


 Example 2:


 Input: root1 = [1], root2 = [1,2]
 Output: [2,2]



 Constraints:


 The number of nodes in both trees is in the range [0, 2000].
 -10⁴ <= Node.val <= 10⁴

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 919 👎 0

 */
public class E_0617_MergeTwoBinaryTrees {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4});
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{1,2,3,null,5});
        TreeNode result = this.mergeTrees(treeNode, treeNode2);
        System.out.println("Tree 1:");
        treeNode.prettyPrint();
        System.out.println("Tree 2:");
        treeNode2.prettyPrint();
        System.out.println("Merge tree 1 and tree 2:");
        result.prettyPrint();
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2==null) {
            return null;
        }
        TreeNode node = new TreeNode();
        int newVal = root1!=null?root1.val:root2.val;
        if (root1!=null&&root2!=null) {
            newVal = root1.val+root2.val;
        }
        node.val = newVal;
        node.left = mergeTrees(root1==null?null:root1.left, root2==null?null:root2.left);
        node.right = mergeTrees(root1==null?null:root1.right, root2==null?null:root2.right);
        return node;
    }
}
