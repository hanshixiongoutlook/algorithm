package hans.leetcode.tree.level;


import com.alibaba.fastjson.JSONObject;
import hans.common.pojo.ListNode;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 同 103
 *
 */
public class LCCI_0403_ListOfDepth {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,null,7,8});
        treeNode.prettyPrint();
        ListNode[] listNodes = this.listOfDepth(treeNode);
        Logger.log(listNodes);
    }
    public ListNode[] listOfDepth(TreeNode root) {
        List<ListNode> list = new LinkedList<>();
        if (root==null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode listNode = new ListNode(Integer.MIN_VALUE);
            list.add(listNode);
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (listNode.val==Integer.MIN_VALUE) {
                    listNode.val = node.val;
                } else {
                    listNode.next = new ListNode(node.val);
                    listNode = listNode.next;
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
        }
        ListNode[] result = new ListNode[list.size()];
        list.toArray(result);
        return result;
    }
}
