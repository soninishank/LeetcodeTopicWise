package Coding.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-shifted-strings/
// 249. Group Shifted Strings
// The actual example present in the questions doesn't justify it fully
// Take an example -  {"ab", "ba"} - but both are different - [[ba], [ab]]
// why ? because - circular loop
//        - ab is 1
//        - ba is 25
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        // A map to store groups of strings with the same shifting pattern
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            // Generate the key for the current string
            String key = getKey(str);

            // Add the string to the corresponding group in the map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Collect all groups as a list of lists
        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        // Create a key based on relative differences
        if (s.length() == 1) {
            return ""; // Single-character strings share the same key
        }

        StringBuilder key = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            // Calculate circular difference and normalize it
            int diff = s.charAt(i) - s.charAt(i - 1);
            // circular loop
            if (diff < 0) {
                diff += 26; // Handle wrap-around
            }
            // Append the difference to the key
            // we need to append the comma to differentiate different keys
            // abn -> 1,12,   b - a = 1     n - a = 12
            // aln -> 11,2,   l - a = 11    n - a = 2
            // If we don't add the comma, it will be treated as the same key which is 112 and that is wrong
            key.append(diff).append(',');
        }
        System.out.println(key);
        return key.toString();
    }

    public static void main(String[] args) {
        String[] words = {"ab", "lma"};
        List<List<String>> lists = new GroupShiftedStrings().groupStrings(words);
        System.out.println(lists);

        String[] words112 = {"ab", "ba"};
        List<List<String>> lists112 = new GroupShiftedStrings().groupStrings(words112);
        System.out.println(lists112);

        String[] words1 = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> lists1 = new GroupShiftedStrings().groupStrings(words1);
        System.out.println(lists1);

        String[] words11 = {"abn", "aln"};
        List<List<String>> lists11 = new GroupShiftedStrings().groupStrings(words11);
        System.out.println(lists11);
    }
}
