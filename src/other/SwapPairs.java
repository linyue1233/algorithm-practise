package other;

public class SwapPairs {
    // 24
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

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            int temp = pre.val;
            pre.val = cur.val;
            cur.val = temp;
            if (cur.next != null) {
                pre = cur.next;
                cur = pre.next;
            } else {
                break;
            }
        }
        return head;
    }
}
