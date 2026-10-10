package leetcode.stacks.concept;

import java.util.*;

/**
 * Implementation through various formats
 * =======================================
 * 1. ArrayList
 * 2. LinkedList
 * 3. Stack (Collection framework)
 */
public class StacksArrayList {
    static class Stack {
        List<Integer> list = new ArrayList<>();

        boolean isEmpty() {
            return list.size() == 0;
        }

        void push(int data) {
            list.add(data);
        }

        int pop() {
            // edge case
            if (isEmpty()) {
                return -1;
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        int peek() {
            // edge case
            if (isEmpty()) {
                return -1;
            }

            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
