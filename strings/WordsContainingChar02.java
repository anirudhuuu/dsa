package strings;

import java.util.ArrayList;
import java.util.List;

/*
 * Find Words Containing Character
 * =================================
 * You are given a 0-indexed array of strings words and a character x.
 *
 * Return an array of indices representing the words
 * that contain the character x.
 *
 * Note that the returned array may be in any order.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n)
 */
public class WordsContainingChar02 {
    List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }

        return result;
    }
}
