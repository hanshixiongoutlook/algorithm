package hans.leetcode.tree.bst;


import hans.algorithm.pojo.ListNode;
import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Runtime:18 ms, faster than 68.40% of Java online submissions.
 Memory Usage:42.2 MB, less than 9.62% of Java online submissions.
 */
public class Medium0173_BinarySearchTreeIterator {

    @Test
    public void test() {
        TreeNode build = TreeNode.buildSearchTree(new int[]{1,2,3,4,5,6,7});

    }
    public static class BSTIterator {
        private Queue<Integer> list;
        public BSTIterator(TreeNode root) {
            if (root!=null) {
                list = new LinkedList<>();
                buildList(root);
            }
        }
        private void buildList(TreeNode root) {
            if (root==null) {
                return;
            }
            buildList(root.left);
            list.offer(root.val);
            buildList(root.right);
        }

        public int next() {
            if (list==null||list.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return list.remove();
        }

        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
}
