package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 同 103
 *
 */
public class M_Offer44_LargestValues {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,6,7});
        treeNode.prettyPrint();
        Logger.log(largestValues(treeNode));
    }

    /**
     * 			Runtime:2 ms, faster than 90.16% of Java online submissions.
     * 			Memory Usage:38.7 MB, less than 27.41% of Java online submissions.
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root==null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer max = null;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (max==null) {
                    max = node.val;
                } else {
                    max = Math.max(max, node.val);
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
