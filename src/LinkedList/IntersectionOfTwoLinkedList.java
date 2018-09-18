package LinkedList;

/*
160. Intersection of Two Linked Lists (Easy)

A:          a1 → a2
                    ↘
                      c1 → c2 → c3
                    ↗
B:    b1 → b2 → b3
要求：时间复杂度为 O(N)，空间复杂度为 O(1)
找出链表的交点

    a + c
    b + c
    => a + c + b = b + c + a
    因此，当访问 A 链表的指针访问到链表尾部时，
    令它从链表 B 的头部开始访问链表 B；
    同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。
    这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while(l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
