package listOperantion;

public class RemoveNthList {
    // 19
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len =getLength(head);
        ListNode temp = new ListNode(0,head);
        ListNode cur = temp;
        for(int i = 0;i<len-n;++i){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return temp.next;
    }

    private int getLength(ListNode head){
        int ans = 0;
        ListNode temp = head;
        while(temp!=null){
            ans++;
            temp = temp.next;
        }
        return ans;
    }
}
