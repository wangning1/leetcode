package com.winner;

/**
 * 查找两个链表相交的点
 */
public class IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        //获取两个链表的长度
        //长的先出发，然后同时走，相遇则是相交的节点

        ListNode pA = headA;
        ListNode pB = headB;
        int aLength = listLength(pA);
        int bLength = listLength(pB);

        if(aLength > bLength){
            int diff = aLength - bLength;
            while (diff-- > 0){
                headA = headA.next;
            }
        }else {
            int diff = bLength - aLength;
            while (diff-- > 0){
                headB = headB.next;
            }
        }

        if(headA == null || headB == null){
            return null;
        }

        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int listLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(6);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);
//        l2.next.next.next = l1.next.next.next;

        ListNode result = getIntersectionNode(l1, l2);
        System.out.println(result.val);
    }
}
