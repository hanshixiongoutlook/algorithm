package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 Given the root of a binary tree, return the lowest common ancestor of its
 deepest leaves.

 Recall that:


 The node of a binary tree is a leaf if and only if it has no children
 The depth of the root of the tree is 0. if the depth of a node is d, the depth
 of each of its children is d + 1.
 The lowest common ancestor of a set S of nodes, is the node A with the largest
 depth such that every node in S is in the subtree with root A.



 Example 1:


 Input: root = [3,5,1,6,2,0,8,null,null,7,4]
 Output: [2,7,4]
 Explanation: We return the node with value 2, colored in yellow in the diagram.
 The nodes coloured in blue are the deepest leaf-nodes of the tree.
 Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2,
 but the depth of nodes 7 and 4 is 3.

 Example 2:


 Input: root = [1]
 Output: [1]
 Explanation: The root is the deepest node in the tree, and it's the lca of
 itself.


 Example 3:


 Input: root = [0,1,3,null,2]
 Output: [2]
 Explanation: The deepest leaf node in the tree is 2, the lca of one node is
 itself.



 Constraints:


 The number of nodes in the tree will be in the range [1, 1000].
 0 <= Node.val <= 1000
 The values of the nodes in the tree are unique.



 Note: This question is the same as 865: https://leetcode.com/problems/smallest-
 subtree-with-all-the-deepest-nodes/
 Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 104 👎 0

 */
public class M_1123_LowestCommonAncestorOfDeepestLeaves {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,null,3,4,null,6,null,5});
        treeNode.prettyPrint();
        TreeNode treeNode1 = lcaDeepestLeaves(treeNode);
        treeNode1.prettyPrint();

        TreeNode treeNode2 = lcaDeepestLeaves2(treeNode);
        treeNode2.prettyPrint();
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:41.1 MB,击败了18.10% 的Java用户
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        /*
             1
         2       3
     4      5  6
        题目：寻找最后一层节点的最小公共祖先
        采用排除法寻找最小公共祖先
        首先假设根节点就是最小公共祖先，
        那么，左子树和右子树的深度一定是相同的
        否则，根节点就不是最小公共祖先
        如果左子树深度>右子树深度，那么最小公共祖先一定在左子树，此时将怀疑对象转移到左侧节点，重复上述判断过程

         */
        if (root.left==null&&root.right==null) {
            return root;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth==rightDepth) {
            return root;
        }
        return lcaDeepestLeaves2(leftDepth>rightDepth?root.left:root.right);
    }
    private int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(depth(treeNode.left) + 1, depth(treeNode.right) + 1);
    }

    /**
     * 			Runtime:5 ms, faster than 5.07% of Java online submissions.
     * 			Memory Usage:38.8 MB, less than 5.07% of Java online submissions.
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root==null) {
            return null;
        }
        // child, parent
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<TreeNode> leaves = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                leaves.add(node);
                if (node.left!=null) {
                    map.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    map.put(node.right, node);
                    queue.offer(node.right);
                }
            }
            if (!queue.isEmpty()) {
                leaves.clear();
            }
        }
        if (leaves.size()==1) {
            return leaves.get(0);
        }
        Set<TreeNode> ancestor = new HashSet<>();
        while (ancestor.size()>1||ancestor.size()==0) {
            for (TreeNode n: leaves) {
                ancestor.add(map.get(n));
            }
            if (ancestor.size()==1) {
                return ancestor.iterator().next();
            }
            leaves.clear();
            leaves.addAll(ancestor);
            ancestor.clear();
        }
        return root;
    }
}
