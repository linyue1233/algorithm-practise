package listOperantion;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoListNode {
    // 445
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


    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ans = null;
            Deque<ListNode> deque1 = new LinkedList<>();
            Deque<ListNode> deque2 = new LinkedList<>();
            ListNode temp = new ListNode(0);
            while (l1 != null) {
                deque1.offerLast(l1);
                l1 = l1.next;
            }
            while (l2 != null) {
                deque2.offerLast(l2);
                l2 = l2.next;
            }
            while (!deque1.isEmpty() || !deque2.isEmpty()) {
                int a = deque1.isEmpty() ? 0 : deque1.pollLast().val;
                int b = deque2.isEmpty() ? 0 : deque2.pollLast().val;
                int sum = a + b;
                if (ans == null) {
                    int t = sum / 10;
                    sum = sum % 10;
                    ans = new ListNode(sum);
                    temp.val = t;
                } else {
                    sum += temp.val;
                    int t = sum / 10;
                    sum = t > 0 ? sum % 10 : sum;
                    addNode(ans, new ListNode(sum));
                    temp = new ListNode(t);
                }
            }
            if (temp.val > 0) {
                addNode(ans, temp);
            }
            ans = reversNodes(ans);
            return ans;
        }


        private void addNode(ListNode result, ListNode temp) {
            if (result.next == null) {
                result.next = temp;
            } else {
                addNode(result.next, temp);
            }
        }

        private ListNode reversNodes(ListNode head) {
            ListNode newHead = new ListNode(-1);
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead.next;
                newHead.next = head;
                head = next;
            }
            return newHead.next;
        }
    }
}
