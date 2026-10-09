package neetcode.stacks;

import java.util.List;
import java.util.ArrayList;

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
        List<Character> stack = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
            } else {
                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.getLast();

                if (ch == ')' && top == '(') {
                    stack.removeLast();
                } else if (ch == '}' && top == '{') {
                    stack.removeLast();
                } else if (ch == ']' && top == '[') {
                    stack.removeLast();
                } else {
                    // Closing bracket doesn't match
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
