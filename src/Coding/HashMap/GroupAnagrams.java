package Coding.HashMap;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
// 49. Group Anagrams
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            char[] currentStr = str.toCharArray();
            Arrays.sort(currentStr);

            if (hashmap.containsKey(String.valueOf(currentStr))) {
                hashmap.get(String.valueOf(currentStr)).add(str);
            } else {
                hashmap.putIfAbsent(String.valueOf(currentStr), new ArrayList<>());
                hashmap.get(String.valueOf(currentStr)).add(str);
            }
        }
        List<List<String>> resultList = new ArrayList<>();
        for (String key : hashmap.keySet()) {
            resultList.add(new ArrayList<>(hashmap.get(key)));
        }
        return resultList;
    }

    // Time complexity - O ( m * n)
    // Space complexity - O ( m * n)
    public List<List<String>> groupAnagramsBetterWay(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> listHashMap = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!listHashMap.containsKey(keyStr)) {
                listHashMap.put(keyStr, new ArrayList<>());
            }
            listHashMap.get(keyStr).add(s);
        }
        return new ArrayList<>(listHashMap.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagramsBetterWay(str);
        System.out.println(lists);
    }
}
