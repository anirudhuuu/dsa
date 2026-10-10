package leetcode.stacks.practice;

import java.util.Stack;

/**
 * Next Greater Element (Right)
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // as long as the stack is not empty
            // get the peek value's index and compare with current value
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        for (int value : nextGreater) {
            System.out.print(value + " ");
        }

        /**
         * Next Greater Element (Right)
         * for (int i = arr.length - 1; i >= 0; i--) {}
         * 
         * Next Greater Element (Left)
         * -> Then update
         * for (int i = 0; i < arr.length; i++) {}
         * 
         * Next Smaller Element (Right)
         * -> while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {}
         * 
         * Next Smaller Element (Left)
         * -> for (int i = 0; i < arr.length; i++) {}
         * while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {}
         */
    }
}
