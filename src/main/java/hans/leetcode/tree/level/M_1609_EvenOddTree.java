package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 Runtime:1 ms, faster than 83.25% of Java online submissions.
 Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
 */
public class M_1609_EvenOddTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17});
        treeNode.prettyPrint();
        Logger.log(isEvenOddTree(treeNode));

    }
    public boolean isEvenOddTree(TreeNode root) {
        if (root==null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        // 当前是奇数层
        boolean isOddlevel = false;
        while (!queue.isEmpty()) {
            TreeNode pre = queue.poll();
            if ((isOddlevel&&pre.val%2==1)||(!isOddlevel&&pre.val%2==0)) {
                return false;
            }
            int size = queue.size();
            if (pre.left!=null) {
                queue.offer(pre.left);
            }
            if (pre.right!=null) {
                queue.offer(pre.right);
            }
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (isOddlevel) {
                    if (node.val%2==1||node.val>=pre.val) {
                        return false;
                    }
                } else {
                    if (node.val%2==0||node.val<=pre.val) {
                        return false;
                    }
                }
                pre = node;
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            isOddlevel = !isOddlevel;
        }
        return true;
    }

}
