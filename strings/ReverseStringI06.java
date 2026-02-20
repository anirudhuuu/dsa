package strings;

/*
 * Reverse String
 * ===============
 * Write a function that reverses a string. The input
 * string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place
 * with O(1) extra memory.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ReverseStringI06 {
    void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start += 1;
            end -= 1;
        }
    }
}
