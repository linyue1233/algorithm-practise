package amazone;

public class ReverseNodeKGroup {
    // 25
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        if (head == null || k == 1) {
            return head;
        }
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 1; cur != null; i++) {
            // reverse does not include start and end
            if (i % k == 0) {
                pre = reverseOneGroup(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverseOneGroup(ListNode pre, ListNode next) {
        ListNode left = pre.next, right = left.next;
        while (right != next) {
            left.next = right.next;
            right.next = pre.next;
            pre.next = right;
            right = left.next;
        }
        return left;
    }
}
