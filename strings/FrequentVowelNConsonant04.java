package strings;

import java.util.*;

/*
 * Find Most Frequent Vowel and Consonant
 * =========================================
 * You are given a string s consisting of lowercase English
 * letters ('a' to 'z').
 *
 * Your task is to:
 * - Find the vowel (one of 'a', 'e', 'i', 'o', or 'u')
 * with the maximum frequency.
 * - Find the consonant (all other letters excluding vowels)
 * with the maximum frequency.
 *
 * Return the sum of the two frequencies.
 *
 * Note: If multiple vowels or consonants have the same
 * maximum frequency, you may choose any one of them. If
 * there are no vowels or no consonants in the string,
 * consider their frequency as 0.
 *
 * The frequency of a letter x is the number of times
 * it occurs in the string.
 */
public class FrequentVowelNConsonant04 {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxFreqSumBrute(String s) {
        Map<Character, Integer> frequency = new HashMap<>();

        int maxVowels = 0;
        int maxConsonants = 0;

        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            char strKey = entry.getKey();

            if (vowels.contains(strKey)) {
                maxVowels = Math.max(maxVowels, entry.getValue());
            } else {
                maxConsonants = Math.max(maxConsonants, entry.getValue());
            }
        }

        return maxVowels + maxConsonants;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxFreqSum(String s) {
        int[] frequency = new int[26];

        int maxVowels = 0;
        int maxConsonants = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            int index = ch - 'a';

            frequency[index]++;

            if (isVowel(ch)) {
                maxVowels = Math.max(maxVowels, frequency[index]);
            } else {
                maxConsonants = Math.max(maxConsonants, frequency[index]);
            }
        }

        return maxVowels + maxConsonants;
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
