/**
 * @Description:
 * @CreateDate: 2020/6/24 16:38
 * @Author: wangning
 * <p>
 * 思路：用一个头指针 来实现通用性
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;

        ListNode p = fakeNode;
        ListNode q = fakeNode;
        int i = 0;
        //p先走n-1步
        while (p != null && i < n) {
            p = p.next;
            i++;
        }

        //当没有n个的时候，返回
        if (p == null) {
            return fakeNode.next;
        }

        //p、q节点同时遍历
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        //执行删除q后面的节点
        ListNode deleteNode = q.next;
        q.next = deleteNode.next;
        deleteNode.next = null;
        deleteNode = null;

        return fakeNode.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution.print(head);
        Solution solution = new Solution();
        Solution.print(solution.removeNthFromEnd(head, 6));
    }
}
