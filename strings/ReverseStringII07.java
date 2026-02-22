package strings;

/*
 * Reverse String II
 * ===================
 * Given a string s and an integer k, reverse the first k characters
 * for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and leave the other as original.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class ReverseStringII07 {
    void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++;
            end--;
        }
    }

    String reverseStr(String s, int k) {
        char[] strArr = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i += 2 * k) {
            /*
             * reversal logic in the 2K window
             *
             * if remaining < k → reverse till end
             * if remaining >= k → reverse first k only
             */
            int start = i;
            int end = Math.min(i + k - 1, n - 1);

            reverse(strArr, start, end);
        }

        return new String(strArr);
    }
}
