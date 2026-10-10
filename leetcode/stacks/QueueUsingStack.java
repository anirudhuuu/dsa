package leetcode.stacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement Queue using Stacks
 * ==============================
 * https://leetcode.com/problems/implement-queue-using-stacks
 * 
 * Implement a first in first out (FIFO) queue using only two stacks. The
 * implemented queue should support all the functions of a normal queue (push,
 * peek, pop, and empty).
 * 
 * Implement the MyQueue class:
 * - void push(int x) Pushes element x to the back of the queue.
 * - int pop() Removes the element from the front of the queue and returns it.
 * - int peek() Returns the element at the front of the queue.
 * - boolean empty() Returns true if the queue is empty, false otherwise.
 * 
 * Notes:
 * - You must use only standard operations of a stack, which means only push to
 * - top, peek/pop from top, size, and is empty operations are valid.
 * - Depending on your language, the stack may not be supported natively. You
 * may
 * - simulate a stack using a list or deque (double-ended queue) as long as you
 * - use only a stack's standard operations.
 * 
 * Example 1:
 * ------------
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 * 
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * 
 * Constraints:
 * ---------------
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 */
class QueueUsingStack {
    List<Integer> stack1; // primary stack
    List<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new ArrayList<>();
        stack2 = new ArrayList<>();
    }

    public void push(int x) {
        // Move all values of stack1 to stack2
        while (!stack1.isEmpty()) {
            int last = stack1.removeLast();
            stack2.add(last);
        }

        // Add the new value to stack1
        stack1.add(x);

        // Move all values of stack2 to stack1
        while (!stack2.isEmpty()) {
            int last = stack2.removeLast();
            stack1.add(last);
        }
    }

    public int pop() {
        return stack1.removeLast();
    }

    public int peek() {
        return stack1.getLast();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
