package LinkedList;

import java.util.*;

/*
链表求和

445. Add Two Numbers II (Medium)

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while(!l1Stack.empty() || !l2Stack.empty() || carry != 0) {
            int x = l1Stack.empty() ? 0 : l1Stack.pop();
            int y = l2Stack.empty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    public Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while(l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
