package strings;

/*
 * Split a String in Balanced Strings
 * ====================================
 * Balanced strings are those that have an equal quantity of
 * 'L' and 'R' characters.
 *
 * Given a balanced string s, split it into some number of
 * substrings such that:
 *
 * Each substring is balanced.
 *
 * Return the maximum number of balanced strings you can obtain.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BalancedStrings05 {
    int balancedStringSplit(String s) {
        int count = 0;

        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                balance += 1;
            } else {
                balance -= 1;
            }

            if (balance == 0) {
                count += 1;
            }
        }

        return count;
    }
}
