package strings;

/*
 * Length of Last Word
 * =======================
 * Given a string s consisting of words and spaces, return the length
 * of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LastWordLength01 {
    int lengthOfLastWord(String s) {
        int lengthofLastWord = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (lengthofLastWord != 0) {
                    break;
                }
            } else {
                lengthofLastWord += 1;
            }
        }

        return lengthofLastWord;
    }
}
