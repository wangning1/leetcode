/**
 * @Description:
 * @CreateDate: 2020/4/4 14:30
 * @Author: wangning
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);

        print(head);
        print(reverseList2(head));
    }

    /**
     * 常见的链表反正节点设置
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        ListNode next = head;
        while (next != null) {
            cur = next;
            next = next.next;
            cur.next = pre;
            pre = cur;
        }
        return cur;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = null;
        ListNode q = head.next;
        while (q != null) {
            head.next = tmp;
            tmp = head;
            head = q;
            q = q.next;
        }
        head.next = tmp;
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
