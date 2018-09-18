package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public int getData() {
        return val;
    }

    public void setData(int data) {
        this.val = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
