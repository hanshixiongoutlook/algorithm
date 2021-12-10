package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 *
 */
public class M_0662_MaximumWidthOfBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,null,3,4,5,6,8,9});
        treeNode.prettyPrint();
        Logger.log(widthOfBinaryTree(treeNode));
    }

    /**
     * 			Runtime:3 ms, faster than 7.50% of Java online submissions.
     * 			Memory Usage:38.1 MB, less than 69.97% of Java online submissions.
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 1;
        Map<TreeNode, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start=0,end=0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i==0) {
                    start=map.getOrDefault(node, 0);
                }
                if (i==(size-1)) {
                    end=map.getOrDefault(node,0);
                }
                if (node.left!=null) {
                    map.put(node.left, 2*map.getOrDefault(node,0)+1);
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    map.put(node.right, 2*map.getOrDefault(node,0)+2);
                    queue.offer(node.right);
                }
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }

}
