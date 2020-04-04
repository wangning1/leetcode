import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @CreateDate: 2020/4/4 19:56
 * @Author: wangning
 */
public class Solution {

    /**
     * 方法1，通过hashSet存储，然后遍历判断是否有重复，如果有则表示有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<Integer> valueSet = new HashSet<>();
        while (head != null) {
            if (valueSet.contains(head.val)) {
                return true;
            }
            valueSet.add(head.val);
            head = head.next;
        }

        return false;
    }

    /**
     * 通过快慢指针 如果相遇 则表示有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null) {
            return false;
        }
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            slow = slow.next.next;
        }
        return false;
    }


}
