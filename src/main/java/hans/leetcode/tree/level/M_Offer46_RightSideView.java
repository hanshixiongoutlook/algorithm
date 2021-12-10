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
public class M_Offer46_RightSideView {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,6});
        treeNode.prettyPrint();
        Logger.log(rightSideView(treeNode));
    }

    /**
     * 			Runtime:1 ms, faster than 89.21% of Java online submissions.
     * 			Memory Usage:37.1 MB, less than 35.32% of Java online submissions.
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
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
                if (i==(size-1)) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
