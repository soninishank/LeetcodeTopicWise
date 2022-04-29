package Coding.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/group-anagrams/
// CTCI  - Chapter 10: Coding.Sorting and Searching
public class GroupAnagrams {

    List<List<String>> resultList = new ArrayList<>();
    List<String> arrayList = new ArrayList<>();

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

    public static void main(String[] args) {
        String str[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(str);
        System.out.println(lists);
    }
}
