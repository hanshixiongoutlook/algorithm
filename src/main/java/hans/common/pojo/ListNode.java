package hans.common.pojo;

public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(Integer[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i=1; i<nums.length;i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }
}
