package Coding.WordSeries;

import java.util.*;

// we need to make breakable sentences
// https://leetcode.com/problems/word-break-ii/
public class WordBreakII {

    // Just simply break in a recursive way
    HashMap<String, List<String>> caching = new HashMap<>();

    public List<String> wordBreakRecursive(String str, Set<String> wordDictionary) {
        if (caching.containsKey(str)) {
            return caching.get(str);
        }
        List<String> result = new ArrayList<>();
        if (str.length() == 0) {
            return result;
        }
        if (wordDictionary.contains(str)) {
            result.add(str);
        }
        for (int i = 1; i <= str.length(); i++) {
            String first = str.substring(0, i);
            if (wordDictionary.contains(first)) {
                List<String> subList = wordBreakRecursive(str.substring(i), wordDictionary);
                for (String sen : subList) {
                    result.add(first + " " + sen); // first word with - remaining sentences - check result
                }
            }
        }
        caching.put(str, result);// cache
        return result;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        List<String> list = new WordBreakII().wordBreakRecursive(s, new HashSet<>(Arrays.asList(wordDict)));
        System.out.println(list);
    }
}
