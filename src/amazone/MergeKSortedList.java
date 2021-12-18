package amazone;

public class MergeKSortedList {
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

    //23
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode n1 = merge(lists, left, mid);
        ListNode n2 = merge(lists, mid + 1, right);
        return mergeTwo(n1, n2);
    }

    private ListNode mergeTwo(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        ListNode preHead = new ListNode(-1);
        ListNode prePoint = preHead;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                prePoint.next = n1;
                n1 = n1.next;
            } else {
                prePoint.next = n2;
                n2 = n2.next;
            }
            prePoint = prePoint.next;
        }
        prePoint.next = n1 == null ? n2 : n1;
        return preHead.next;
    }
}
