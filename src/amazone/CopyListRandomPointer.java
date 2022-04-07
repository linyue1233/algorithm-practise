package amazone;

public class CopyListRandomPointer {
    // 138
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // clone original list, from  1-2-3 to 1-1-2-2-3-3
        Node temp = head;
        while (temp != null) {
            Node cloneNode = new Node(temp.val);
            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;
        }
        // handle random node
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node dummy = new Node(-1);
        Node cur = dummy;
        while (temp != null) {
            cur.next = temp.next;
            cur = cur.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
