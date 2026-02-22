package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * Isomorphic Strings
 * ====================
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class IsomorphicStrings12 {
    boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapStoT.containsKey(charS)) {
                if (mapStoT.get(charS) != charT) {
                    return false;
                }
            } else {
                mapStoT.put(charS, charT);
            }

            if (mapTtoS.containsKey(charT)) {
                if (mapTtoS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTtoS.put(charT, charS);
            }
        }

        return true;
    }
}
