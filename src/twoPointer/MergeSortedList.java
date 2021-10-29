package twoPointer;


public class MergeSortedList {
    // 21

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

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prePoint = preHead;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                prePoint.next = l1;
                l1 = l1.next;
            }else{
                prePoint.next = l2;
                l2 = l2.next;
            }
            prePoint = prePoint.next;
        }
        prePoint.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
