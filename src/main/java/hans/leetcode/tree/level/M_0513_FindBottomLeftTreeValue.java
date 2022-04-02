package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given the root of a binary tree, return the leftmost value in the last row of
 the tree.


 Example 1:


 Input: root = [2,1,3]
 Output: 1


 Example 2:


 Input: root = [1,2,3,4,null,5,6,null,null,7]
 Output: 7



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁴].
 -2³¹ <= Node.val <= 2³¹ - 1

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 258 👎 0

 */
public class M_0513_FindBottomLeftTreeValue {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,6,7});
        treeNode.prettyPrint();
        Logger.log(findBottomLeftValue(treeNode));
    }

    /**
     * 			执行耗时:1 ms,击败了68.95% 的Java用户
     * 			内存消耗:38 MB,击败了62.33% 的Java用户
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root==null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left=-1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size;i++) {
                TreeNode node = queue.poll();
                if (i==0) {
                    left = node.val;
                }
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return left;
    }
}
