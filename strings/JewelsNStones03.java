package strings;

import java.util.HashSet;
import java.util.Set;

/*
 * Jewels and Stones
 * ===================
 * You're given strings jewels representing the types of stones that
 * are jewels, and stones representing the stones you have. Each
 * character in stones is a type of stone you have. You want to
 * know how many of the stones you have are also jewels.
 *
 * Letters are case-sensitive, so "a" is considered a different
 * type of stone from "A".
 */
public class JewelsNStones03 {
    /*
     * Time Complexity: O(j * s)
     * Space Complexity: O(1)
     */
    int numJewelsInStonesBrute(String jewels, String stones) {
        int count = 0;

        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (stones.charAt(j) == jewels.charAt(i)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    /*
     * Time Complexity: O(j + s)
     * Space Complexity: O(j)
     */
    int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        Set<Character> jewelsBox = new HashSet<>();
        char[] jewelsList = jewels.toCharArray();

        for (char jewel : jewelsList) {
            jewelsBox.add(jewel);
        }

        for (int i = 0; i < stones.length(); i++) {
            if (jewelsBox.contains(stones.charAt(i))) {
                count += 1;
            }
        }

        return count;
    }
}
