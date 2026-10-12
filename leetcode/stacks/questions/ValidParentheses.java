package leetcode.stacks.questions;

import java.util.Stack;

/**
 * Valid Parentheses
 * ==================
 * https://leetcode.com/problems/valid-parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example 1:
 * ------------
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * -----------
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * ------------
 * Input: s = "(]"
 * Output: false
 * 
 * Example 4:
 * ------------
 * Input: s = "([])"
 * Output: true
 * 
 * Example 5:
 * ------------
 * Input: s = "([)]"
 * Output: false
 * 
 * Constraints:
 * ------------
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
class ValidParentheses {
    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // No opening bracket available
                if (stack.empty()) {
                    return false;
                }

                char top = stack.peek();

                if (ch == ')' && top == '(') {
                    stack.pop();
                } else if (ch == '}' && top == '{') {
                    stack.pop();
                } else if (ch == ']' && top == '[') {
                    stack.pop();
                } else {
                    // Closing bracket doesn't match
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
