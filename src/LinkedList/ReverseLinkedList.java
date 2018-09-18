package LinkedList;

/*
链表反转

206. Reverse Linked List (Easy)


 */
public class ReverseLinkedList {
    // 1. 递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    // 2. 头插法
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
