package leetcode.stacks.practice;

import java.util.*;

/**
 * Reverse a String using a Stack
 */
public class ReverseString {
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        int index = 0;
        while (index < str.length()) {
            stack.push(str.charAt(index));
            index += 1;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abc"));
    }
}
