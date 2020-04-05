import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description:
 * @CreateDate: 2020/4/5 14:24
 * @Author: wangning
 */
public class KthLargest {

    Queue<Integer> queue;
    int kLen;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        kLen = k;
        for (Integer num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < kLen) {
            queue.offer(val);
        } else {
            if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));
        ;   // returns 4
        System.out.println(kthLargest.add(5));
        ;   // returns 5
        System.out.println(kthLargest.add(10));
        ;  // returns 5
        System.out.println(kthLargest.add(9));
        ;   // returns 8
        System.out.println(kthLargest.add(4));
        ;   // returns 8

    }
}
