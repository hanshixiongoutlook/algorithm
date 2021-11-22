package hans.leetcode.tree.bst;


import hans.common.pojo.ListNode;
import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 效率不算高需要看下题解
 * 关联：LCCI0402
 */
public class M_0109_ConvertSortedListToBinarySearchTree {

    @Test
    public void test() {
        ListNode build = ListNode.build(new Integer[]{-10,-3,0,5,9});
        TreeNode mode = this.sortedListToBST(build);
        mode.prettyPrint();
        mode.arrayPrint();
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        ListNode next = head;
        while ((next=next.next)!=null) {
            list.add(next.val);
        }
        return sortedArrayToBST(list, 0, list.size()-1);
    }

    public TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if (start>end) {
            return null;
        }
        TreeNode root = new TreeNode(nums.get((end-start)/2+start));
        root.left = sortedArrayToBST(nums, start, (end-start)/2+start-1);
        root.right = sortedArrayToBST(nums, (end-start)/2+start+1, end);
        return root;
    }
}
