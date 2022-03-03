package amazone;

public class MergeKListNode {
    // 23
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftNode = merge(lists, left, mid);
        ListNode rightNode = merge(lists, mid + 1, right);
        return mergeTwo(leftNode, rightNode);
    }

    public ListNode mergeTwo(ListNode leftNode, ListNode rightNode) {
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;
        ListNode ans = new ListNode(-1);
        ListNode point = ans;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val <= rightNode.val) {
                point.next = leftNode;
                leftNode = leftNode.next;
            } else {
                point.next = rightNode;
                rightNode = rightNode.next;
            }
            point = point.next;
        }
        point.next = leftNode == null ? rightNode : leftNode;
        return ans.next;
    }
}
