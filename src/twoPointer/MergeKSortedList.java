package twoPointer;

public class MergeKSortedList {
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
        ListNode ans = new ListNode();
        int k = lists.length;
        ans = ans.next;
        if(k==0) return ans;
        if(k==1) return lists[0];
        if(k==2) return mergeTwoList(lists[0],lists[1]);
        while(k>=1){
            ans = mergeTwoList(ans,lists[k-1]);
            --k;
        }
        return ans;
    }

    private ListNode mergeTwoList(ListNode left, ListNode right){
        ListNode preHead = new ListNode(-1);
        ListNode prePoint = preHead;
        while(left!=null && right != null){
            if(left.val <= right.val){
                prePoint.next = left;
                left = left.next;
            }else{
                prePoint.next = right;
                right = right.next;
            }
            prePoint = prePoint.next;
        }
        prePoint.next = left == null ? right : left;
        return preHead.next;
    }
}
