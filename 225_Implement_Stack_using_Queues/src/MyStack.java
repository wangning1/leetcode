import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @CreateDate: 2020/4/5 11:42
 * @Author: wangning
 */
public class MyStack {

    Queue<Integer> inQueue;
    Queue<Integer> tempQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        inQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        inQueue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        if(inQueue.isEmpty()){
            throw new IllegalArgumentException("no element");
        }
        while (inQueue.size() > 1) {
            tempQueue.add(inQueue.poll());
        }

        Integer top = inQueue.poll();
        Queue<Integer> tmp = tempQueue;
        tempQueue = inQueue;
        inQueue = tmp;
        return top;

    }

    /**
     * Get the top element.
     */
    public int top() {
        if(inQueue.isEmpty()){
            throw new IllegalArgumentException("no element");
        }
        while (inQueue.size() > 1) {
            tempQueue.add(inQueue.poll());
        }
        return inQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inQueue.isEmpty() && tempQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(2);
        myStack.push(3);
        myStack.push(1);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());

    }
}
