package LinkedList;

/*
回文链表

234. Palindrome Linked List (Easy)

题目要求：以 O(1) 的空间复杂度来求解。

切成两半，把后半段反转，然后比较两半是否相等。
 */

import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) slow = slow.next;
        cut(head, slow);
        return isEqual(head, reverse(slow));
    }

    private void cut(ListNode head, ListNode cutNode) {
        while(head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
