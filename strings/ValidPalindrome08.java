package strings;

/*
 * Valid Palindrome
 * ===================
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads
 * the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class ValidPalindrome08 {
    String reverse(char[] str) {
        int start = 0;
        int end = str.length - 1;

        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++;
            end--;
        }

        return new String(str);
    }

    boolean isPalindrome(String s) {
        String filteredStr = s
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        String reversed = reverse(filteredStr.toCharArray());

        return filteredStr.equals(reversed);
    }
}
