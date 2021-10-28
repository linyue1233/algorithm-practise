package listOperantion;

public class ReverseList {
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

    //206
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode ans = null;
        while (curNode != null) {
            ListNode tempNext = curNode.next;
            curNode.next = ans;
            ans = curNode;
            curNode = tempNext;
        }
        return ans;
    }
}
