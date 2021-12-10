package hans.leetcode.tree.design;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 */
public class M_0919_CompleteBinaryTreeInserter {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode();
        treeNode.prettyPrint();
        CBTInserter cbtInserter = new CBTInserter(treeNode);
        cbtInserter.insert(6);
        cbtInserter.get_root().prettyPrint();
        cbtInserter.insert(7);
        cbtInserter.get_root().prettyPrint();
        cbtInserter.insert(8);
        cbtInserter.get_root().prettyPrint();
    }

    /**
     * 			执行耗时:20 ms,击败了15.09% 的Java用户
     * 			内存消耗:39.1 MB,击败了72.78% 的Java用户
     */
    class CBTInserter {

        public TreeNode root;
        public Deque<TreeNode> nullNodes;

        public CBTInserter(TreeNode root) {
            this.root = root;
            nullNodes = new LinkedList<>();
            build();
        }

        public void build() {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for (int i=0; i<size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left==null || poll.right==null) {
                        nullNodes.add(poll);
                    }
                    if (poll.left!=null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right!=null) {
                        queue.offer(poll.right);
                    }
                }
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            TreeNode first = nullNodes.getFirst();
            if (first.left==null) {
                first.left = node;
                nullNodes.add(node);
            } else {
                first.right = node;
                nullNodes.removeFirst();
                nullNodes.add(node);
            }
            return first.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
