package Coding.WordSeries;

import java.util.*;

// https://leetcode.com/problems/word-break/
public class WordBreakI {

    Map<String, Boolean> caching = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        HashSet<String> hashSet = new HashSet<>(wordDict);
        return applyDFS(s, hashSet);
    }

    private boolean applyDFS(String str, HashSet<String> wordDictionary) {
        if (str.length() == 0) {
            return true;
        }
        if (caching.containsKey(str)) {
            return caching.get(str);
        }
        for (int i = 1; i <= str.length(); i++) {
            String firstSubstring = str.substring(0, i);
            if (wordDictionary.contains(firstSubstring)) {
                String remaining = str.substring(i); // iterate over the remaining string
                if (applyDFS(remaining, wordDictionary)) {
                    caching.put(str, true);// if present - true
                    return true;
                }
            }
        }
        caching.put(str, false);
        return false;
    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] wordDict = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        boolean b = new WordBreakI().wordBreak(s, Arrays.asList(wordDict));
        System.out.println(b);
    }
}
