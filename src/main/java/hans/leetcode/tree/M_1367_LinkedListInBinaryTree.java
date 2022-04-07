package hans.leetcode.tree;


import hans.common.pojo.ListNode;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。

 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。


 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。



 示例 1：



 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1
 ,3]
 输出：true
 解释：树中蓝色的节点构成了与链表对应的子路径。


 示例 2：



 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
 null,1,3]
 输出：true


 示例 3：

 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
 null,1,3]
 输出：false
 解释：二叉树中不存在一一对应链表的路径。




 提示：


 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
 链表包含的节点数目在 1 到 100 之间。
 二叉树包含的节点数目在 1 到 2500 之间。

 Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 125 👎 0

 */

public class M_1367_LinkedListInBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3});
        treeNode1.prettyPrint();
        ListNode list = ListNode.build(new Integer[]{4,2,8});
        Logger.log(isSubPath(list, treeNode1));
//        Logger.log("target = {}", listStr);
//        Logger.log("find = {}", findStr);

    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root==null) {
            return false;
        }
        dfs(head, root);
        return dfs(head, root)||isSubPath(head, root.left)||isSubPath(head, root.right);
    }
    public boolean dfs(ListNode list, TreeNode root) {
        if (list==null) {
            return true;
        }
        if (root==null||list.val!=root.val) {
            return false;
        }
        return dfs(list.next, root.left)||dfs(list.next, root.right);
    }
    class Solution1{
        String listStr;
        String findStr = null;

        /**
         * 			Runtime:46 ms, faster than 5.82% of Java online submissions.
         * 			Memory Usage:54.3 MB, less than 5.02% of Java online submissions.
         * @param head
         * @param root
         * @return
         */
        public boolean isSubPath(ListNode head, TreeNode root) {
            StringBuilder buf = new StringBuilder();
            ListNode next = head;
            while(next!=null) {
                buf.append(next.val).append(",");
                next = next.next;
            }
            listStr = buf.toString();
            dfs(root, "");
            return findStr!=null;
        }

        public void dfs(TreeNode root, String parent) {
            if (root==null) {
                return ;
            }
            String str = parent+root.val+",";
            dfs(root.left, str);
            dfs(root.right, str);
            if (str.contains(listStr)) {
                findStr = str;
                return;
            }
        }
    }


}
