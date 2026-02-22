package strings;

/*
 * Largest Odd Number in String
 * ==============================
 * You are given a string num, representing a large integer. Return the
 * largest-valued odd integer (as a string) that is a non-empty substring
 * of num, or an empty string "" if no odd integer exists.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LargestOddNumber10 {
    String largestOddNumber(String num) {
        int endIndex = num.length() - 1;
        String result = "";

        while (endIndex >= 0) {
            int number = num.charAt(endIndex) - '0';
            if (number % 2 == 0) {
                endIndex--;
            } else {
                break;
            }
        }

        result = num.substring(0, endIndex + 1);

        return result;
    }
}
