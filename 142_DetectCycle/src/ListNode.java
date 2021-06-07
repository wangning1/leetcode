package com.winner;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

}
