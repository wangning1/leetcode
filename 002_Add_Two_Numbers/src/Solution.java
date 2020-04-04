/**
 * @Description:给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @CreateDate: 2020/4/4 11:54
 * @Author: wangning
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        printList(l1);

        ListNode l2 = new ListNode(5);
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addForword = 0;
        ListNode ListHead = null;
        ListNode listTail = null;
        while (l1 != null && l2 != null) {
            int newVal = (l1.val + l2.val + addForword) % 10;
            addForword = (l1.val + l2.val + addForword) / 10;
            ListNode node = new ListNode(newVal);
            if (ListHead == null) {
                ListHead = node;
                listTail = node;
            } else {
                listTail.next = node;
                listTail = node;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int oldValue = l1.val;
            l1.val = (oldValue + addForword) % 10;
            addForword = (oldValue + addForword) / 10;
            listTail.next = l1;
            listTail = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            int oldValue = l2.val;
            l2.val = (oldValue + addForword) % 10;
            addForword = (oldValue + addForword) / 10;
            listTail.next = l2;
            listTail = l2;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null && addForword != 0) {
            ListNode listNode = new ListNode(addForword);
            listTail.next = listNode;
            listTail = listNode;
        }

        return ListHead;
    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }
}


