package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 Given the root of a binary tree and two integers val and depth, add a row of
 nodes with value val at the given depth depth.

 Note that the root node is at depth 1.

 The adding rule is:


 Given the integer depth, for each not null tree node cur at the depth depth - 1
 , create two tree nodes with value val as cur's left subtree root and right
 subtree root.
 cur's original left subtree should be the left subtree of the new left subtree
 root.
 cur's original right subtree should be the right subtree of the new right
 subtree root.
 If depth == 1 that means there is no depth depth - 1 at all, then create a
 tree node with value val as the new root of the whole original tree, and the
 original tree is the new root's left subtree.



 Example 1:


 Input: root = [4,2,6,3,1,5], val = 1, depth = 2
 Output: [4,1,1,2,null,null,6,3,1,5]


 Example 2:


 Input: root = [4,2,null,3,1], val = 1, depth = 3
 Output: [4,2,null,1,1,3,null,null,1]



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁴].
 The depth of the tree is in the range [1, 10⁴].
 -100 <= Node.val <= 100
 -10⁵ <= val <= 10⁵
 1 <= depth <= the depth of tree + 1

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 110 👎 0

 */
public class M_0623_AddOneRowToTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{4,2,6,3,1,5});
        treeNode.prettyPrint();
        treeNode = addOneRow(treeNode,1,1);
        treeNode.prettyPrint();
    }

    /**
     * 			执行耗时:1 ms,击败了53.66% 的Java用户
     * 			内存消耗:38.3 MB,击败了61.22% 的Java用户
     * @param root
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth==1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level=1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if ((depth-1)==level) {
                    TreeNode nodel = new TreeNode(val);
                    nodel.left = cur.left;
                    cur.left = nodel;

                    TreeNode noder = new TreeNode(val);
                    noder.right = cur.right;
                    cur.right = noder;
                }
                if (cur.left!=null) {
                    queue.offer(cur.left);
                }
                if (cur.right!=null) {
                    queue.offer(cur.right);
                }
            }
            if (depth==level) {
                return root;
            }
            level++;
        }
        return root;
    }
}
