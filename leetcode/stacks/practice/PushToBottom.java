package leetcode.stacks.practice;

import java.util.*;

/**
 * Push at the Bottom of the Stack
 */
public class PushToBottom {
    public static void pustAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pustAtBottom(s, data);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        pustAtBottom(stack, 4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
