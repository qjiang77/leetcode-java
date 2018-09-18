package LinkedList;

/*
交换链表中的相邻结点

24. Swap Nodes in Pairs (Medium)

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while(node.next != null && node.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return node.next;
    }
}
