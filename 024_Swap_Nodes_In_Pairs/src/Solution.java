/**
 * @Description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @CreateDate: 2020/4/4 15:16
 * @Author: wangning
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        printList(head);
        printList(beutifulSwapPairs(head));
    }

    public static ListNode beutifulSwapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode dummy = pre;
        pre.next = head;
        ListNode a;
        ListNode b;
        while (pre.next != null && pre.next.next != null) {
            a = pre.next;
            b = a.next;
            a.next = b.next;
            pre.next = b;
            b.next = a;
            pre = a;
        }
        return dummy.next;
    }

    /**
     * 常规解法
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = cur.next;
        ListNode nnext = next.next;
        head = next;
        while (next != null) {
            next.next = cur;
            if (nnext == null) {
                cur.next = nnext;
                break;
            }
            if (nnext.next != null) {
                cur.next = nnext.next;
                next = nnext.next;
            } else {
                cur.next = nnext;
                next = null;
                break;
            }
            cur = nnext;
            nnext = next.next;
        }
        return head;
    }


    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
