package hans.leetcode.tree.bst;

import hans.common.pojo.Node;
import hans.common.pojo.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class M_OFFER36_treeToDoublyList {

    @Test
    public void test() {
        Integer[] arr = new Integer[]{3,1,4,Integer.MIN_VALUE,2};
        TreeNode integerTreeNode = TreeNode.buildTree(arr);
        integerTreeNode.prettyPrint();
    }

    public Node treeToDoublyList(Node root) {
        if (root==null) {
            return null;
        }
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    Node head;
    Node tail;
    Node pre;

    public void dfs(Node root) {
        if (root==null) {
            return;
        }
        dfs(root.left);
        tail = root;
        if (head==null) {
            head = root;
        }
        if (pre==null) {
            pre=root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        dfs(root.right);

    }
}
