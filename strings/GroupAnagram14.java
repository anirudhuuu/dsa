package strings;

import java.util.*;

/**
 * Group Anagrams
 * ===============
 * Given an array of strings strs, group the together.
 * You can return the answer in any order.
 */
public class GroupAnagram14 {
    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] frequencyList = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequencyList[s.charAt(i) - 'a']++;
            frequencyList[t.charAt(i) - 'a']--;
        }

        for (int num : frequencyList) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Time Complexity: O(n^2 * k)
     * Space Complexity: O(n)
     */
    List<List<String>> groupAnagramsBrute(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(group);
        }

        return result;
    }

    /**
     * Time Complexity: O(n * k log k)
     * Space Complexity: O(n * k)
     */
    List<List<String>> groupAnagramsBetter(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            char[] sortedWord = s.toCharArray();
            Arrays.sort(sortedWord);
            String sortedStr = new String(sortedWord);

            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }

            anagramMap.get(sortedStr).add(s);
        }

        for (Map.Entry<String, List<String>> entry :anagramMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
