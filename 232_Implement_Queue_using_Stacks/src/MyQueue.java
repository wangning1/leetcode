import java.util.Iterator;
import java.util.Stack;

/**
 * @Description:
 * @CreateDate: 2020/4/5 10:15
 * @Author: wangning
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println( queue.empty());; // returns false
    }

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!outStack.empty()) {
            return outStack.pop();
        }

        if (!inStack.empty()) {
            Iterator<Integer> iterator = inStack.iterator();
            while (iterator.hasNext()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
        throw new IllegalArgumentException("no element");
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!outStack.empty()) {
            return outStack.peek();
        }

        if (!inStack.empty()) {
            Iterator<Integer> iterator = inStack.iterator();
            while (iterator.hasNext()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
        throw new IllegalArgumentException("no element");
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}
