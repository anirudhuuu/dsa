package leetcode.concept;

import java.util.*;

/**
 * Implementation through various formats
 * =======================================
 * 1. ArrayList
 * 2. LinkedList
 * 3. Stack (Collection framework)
 */
public class StacksCollection {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
