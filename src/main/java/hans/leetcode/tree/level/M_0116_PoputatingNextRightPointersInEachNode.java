package hans.leetcode.tree.level;


import hans.common.pojo.Node;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;


public class M_0116_PoputatingNextRightPointersInEachNode {

    @Test
    public void test() {
        Node treeNode = Node.buildTreeWithoutConnect(new Integer[]{1,2,3,4,5,6,7});
        treeNode.prettyPrint();
        connect(treeNode);
        treeNode.prettyPrint();
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:38.6 MB, less than 72.87% of Java online submissions.
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root==null) {
            return root;
        }
        Node leftMost = root;
        while(leftMost.left!=null) {
            Node head = leftMost;
            while(head!=null) {
                head.left.next = head.right;
                if (head.next!=null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
    /**
     * 			Runtime:2 ms, faster than 31.08% of Java online submissions.
     * 			Memory Usage:38 MB, less than 61.17% of Java online submissions.
     */
    public Node connect2(Node root) {
        if (root==null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i=0; i<count;i++) {
                Node node = queue.poll();
                if (i<count-1) {
                    node.next = queue.peek();
                }
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

}
