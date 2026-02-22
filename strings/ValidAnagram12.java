package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Valid Anagram
 * ================
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram12 {
    /*
     * Brute force approach
     * ----------------------
     * Time Complexity: O(n log n * m)
     * Space Complexity: O(m)
     */
    boolean isAnagramBrute(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }

    /*
     * Frequency map approach
     * -----------------------
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            Integer count = frequency.get(ch);

            if (count == null || count == 0) {
                return false;
            }

            frequency.put(ch, count - 1);
        }

        return true;
    }

    /*
     * Optimal Solution
     * ------------------
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] frequencyList = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequencyList[s.charAt(i) - 'a']++;
            frequencyList[t.charAt(i) - 'a']--;
        }

        for (int num : frequencyList) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
