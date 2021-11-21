package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;


public class EasyLCCI1712_convertBiNode {

    @Test
    public void test() {
//        1,2,2,3,3,null,null,4,4
        // 3,9,20,null,null,15,7
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{4,2,5,1,3,null,6,0});
        treeNode.prettyPrint();

        TreeNode result = this.convertBiNode(treeNode);
        result.prettyPrint();
    }
    TreeNode head = null;   // 为了返回单向链表的头节点而多设的一个节点
    TreeNode perv = null;               // 指向当前节点的前一个节点
    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head;
    }

    public void helper(TreeNode root) {
        if (root == null) { return;}
        helper(root.left);
        if (perv == null) {     // 第一个节点
            perv = root;        // 记录第一个节点
            head = root;  // 记录它，它将作为单链表的表头
        } else {                // 第一个节点之后的节点
            perv.right = root;  // 前一个节点的右指针指向当前节点
            perv = root;        // 更新perv指向
        }
        root.left = null;       // 当前节点的左指针设为null
        helper(root.right);
    }
}
