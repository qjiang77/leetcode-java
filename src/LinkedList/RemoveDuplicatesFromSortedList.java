package LinkedList;

/*
从有序链表中删除重复节点

83. Remove Duplicates from Sorted List (Easy)
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val? head.next : head;
    }
}
