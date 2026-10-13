package leetcode.stacks.questions;

import java.util.Stack;

/**
 * Decode String
 * ===============
 * https://leetcode.com/problems/decode-string
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits are
 * only for those repeat numbers, k. For example, there will not be input like
 * 3a or 2[4].
 * 
 * The test cases are generated so that the length of the output will never
 * exceed 105.
 * 
 * Example 1:
 * ------------
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * Example 2:
 * ------------
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 * Example 3:
 * ------------
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * 
 * Constraints:
 * ------------
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
class DecodeString {
    String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                String subString = "";

                while (stack.peek() != '[') {
                    subString = stack.pop() + subString;
                }
                // to remove the opening bracket
                stack.pop();

                // Digit of repeats
                String k = "";
                while (!stack.empty() && Character.isDigit(stack.peek())) {
                    k = stack.pop() + k;
                }

                // Repeat the substring
                String repeated = subString.repeat(Integer.parseInt(k));

                // Push the repeated characters back
                for (char ch : repeated.toCharArray()) {
                    stack.push(ch);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}
