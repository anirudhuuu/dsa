package strings;

import java.util.Arrays;

/*
 * Longest Common Prefix
 * ======================
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Time Complexity: O(n log n * m)
 * Space Complexity: O(m)
 *
 * n → how many strings
 * m → how long each string is
 */
public class LongestCommonPrefix11 {
    String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        Arrays.sort(strs);

        // Check the first and last values in the "sorted list"
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        // Compare the values one-by-one
        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i]) {
                break;
            }

            result.append(first[i]);
        }

        return result.toString();
    }
}
