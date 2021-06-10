package com.winner;

/**
 * 合并两个有序列表成一个
 */
public class MergeTwoList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode resultDummy = new ListNode(-1);
        ListNode head = resultDummy;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if(l1 == null){
            head.next = l2;
        }else {
            head.next = l1;
        }

        return resultDummy.next;
    }


    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
       if(l1 == null){
           return l2;
       }
       if(l2 == null){
           return l1;
       }

       ListNode pHead = null;
       if(l1.val < l2.val){
           pHead = l1;
           pHead.next = mergeTwoLists2(l1.next, l2);
       }else {
           pHead = l2;
           pHead.next = mergeTwoLists(l1, l2.next);
       }
       return pHead;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);
        l2.next.next.next = new ListNode(6);
        ListNode result = mergeTwoLists2(l1, l2);
        ListNode.printList(result);

    }
}
