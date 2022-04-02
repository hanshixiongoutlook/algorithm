package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given the root of a binary tree with unique values and the values of two
 different nodes of the tree x and y, return true if the nodes corresponding to the
 values x and y in the tree are cousins, or false otherwise.

 Two nodes of a binary tree are cousins if they have the same depth with
 different parents.

 Note that in a binary tree, the root node is at the depth 0, and children of
 each depth k node are at the depth k + 1.


 Example 1:


 Input: root = [1,2,3,4], x = 4, y = 3
 Output: false


 Example 2:


 Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 Output: true


 Example 3:


 Input: root = [1,2,3,null,4], x = 2, y = 3
 Output: false



 Constraints:


 The number of nodes in the tree is in the range [2, 100].
 1 <= Node.val <= 100
 Each node has a unique value.
 x != y
 x and y are exist in the tree.

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 263 👎 0

 */
public class E_0993_CousinsInBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        treeNode.prettyPrint();
        boolean result = this.isCousins(treeNode, 8, 15);
        // [3.00000,14.50000,11.00000]
        Logger.log(result);
    }
    public boolean is(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level=0;
        TreeNode xn = null;
        TreeNode yn = null;
        int xL = 0;
        int yL = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left!=null) {
                if (x==node.left.val) {
                    xL = level+1;
                    xn = node;
                }
                if (y==node.left.val) {
                    yL = level+1;
                    yn = node;
                }
                queue.add(node.left);
            }
            if (node.right!=null) {
                if (x==node.right.val) {
                    xL = level+1;
                    xn = node;
                }
                if (y==node.right.val) {
                    yL = level+1;
                    yn = node;
                }
                queue.add(node.right);
            }
            level++;
        }
        return (xL==yL) && (xn!=null && xn.val!=yn.val);
    }


    int xDepth = -1;
    int yDepth = -1;
    TreeNode xParent = null;
    TreeNode yParent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.find(root, null, 0, x, y);
        if (xDepth==-1&&yDepth==-1) {
            return false;
        }
        if (xParent==null||yParent==null) {
            return false;
        }
        return xDepth==yDepth && xParent.val!=yParent.val;
    }

    public void find(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null) {
            return;
        }
        if (x==root.val) {
            xDepth=depth;
            xParent = parent;
        }
        if (y==root.val) {
            yDepth=depth;
            yParent = parent;
        }
        if (xDepth!=-1&&yDepth!=-1) {
            return;
        }

        find(root.left, root, depth+1, x, y);
        find(root.right, root, depth+1, x, y);
    }


}
