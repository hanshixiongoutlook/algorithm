package hans.leetcode.tree;


import hans.common.pojo.ListNode;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
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
