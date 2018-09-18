package LinkedList;

/*
删除链表的倒数第 n 个节点

19. Remove Nth Node From End of List (Medium)

Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

快慢指针思路
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n > 0) {
            fast = fast.next;
        }
        if(fast == null) return head.next;
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
