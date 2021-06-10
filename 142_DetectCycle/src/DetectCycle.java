package com.winner;

import java.util.HashSet;

/**
 * 找到入环的节点
 */
public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ptr = fast;
                break;
            }
        }
        ListNode tmp = head;

        if (ptr != null) {
            while (ptr != tmp) {
                ptr = ptr.next;
                tmp = tmp.next;
            }
            return tmp;
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        HashSet<ListNode> listNodeHashSet = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if(listNodeHashSet.contains(p)){
               return p;
            }
            listNodeHashSet.add(p);
            p = p.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = head.next.next;
        ListNode result = detectCycle2(head);
        System.out.println(result.val);
    }

}
