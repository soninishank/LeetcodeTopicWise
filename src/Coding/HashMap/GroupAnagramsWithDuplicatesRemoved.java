package Coding.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsWithDuplicatesRemoved {

    public List<List<String>> groupAnagramDuplicates(String[] str) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String val : str) {
            String s = val.toLowerCase();
            char[] count = new char[26];
            for (int i = 0; i < s.length(); i++) {
                if (count[s.charAt(i) - 'a'] == 0) {
                    count[s.charAt(i) - 'a']++;
                }
            }
            String substr = String.valueOf(count);
            hashMap.putIfAbsent(substr, new ArrayList<>());
            hashMap.get(substr).add(val);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] str = {"Good", "pan", "nap", "dog", "god"};
        List<List<String>> lists = new GroupAnagramsWithDuplicatesRemoved().groupAnagramDuplicates(str);
        System.out.println(lists);
    }
}
