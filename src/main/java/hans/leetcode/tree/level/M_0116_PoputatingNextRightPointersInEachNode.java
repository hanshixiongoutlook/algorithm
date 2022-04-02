package hans.leetcode.tree.level;


import hans.common.pojo.LinkedTreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 You are given a perfect binary tree where all leaves are on the same level, and
 every parent has two children. The binary tree has the following definition:


 struct Node {
 int val;
 Node *left;
 Node *right;
 Node *next;
 }


 Populate each next pointer to point to its next right node. If there is no
 next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.


 Example 1:


 Input: root = [1,2,3,4,5,6,7]
 Output: [1,#,2,3,#,4,5,6,7,#]
 Explanation: Given the above perfect binary tree (Figure A), your function
 should populate each next pointer to point to its next right node, just like in
 Figure B. The serialized output is in level order as connected by the next pointers,
 with '#' signifying the end of each level.


 Example 2:


 Input: root = []
 Output: []



 Constraints:


 The number of nodes in the tree is in the range [0, 2¹² - 1].
 -1000 <= Node.val <= 1000



 Follow-up:


 You may only use constant extra space.
 The recursive approach is fine. You may assume implicit stack space does not
 count as extra space for this problem.

 Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 714 👎 0

 */
public class M_0116_PoputatingNextRightPointersInEachNode {

    @Test
    public void test() {
        LinkedTreeNode treeNode = LinkedTreeNode.buildTreeWithoutConnect(new Integer[]{1,2,3,4,5,6,7});
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
    public LinkedTreeNode connect(LinkedTreeNode root) {
        if (root==null) {
            return root;
        }
        LinkedTreeNode leftMost = root;
        while(leftMost.left!=null) {
            LinkedTreeNode head = leftMost;
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
    public LinkedTreeNode connect2(LinkedTreeNode root) {
        if (root==null) {
            return root;
        }
        Queue<LinkedTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i=0; i<count;i++) {
                LinkedTreeNode node = queue.poll();
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
