package WordSeries;

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

    private boolean applyDFS(String s, HashSet<String> hashSet) {
        if (s.length() == 0) {
            return true;
        }
        if (caching.containsKey(s)) {
            return caching.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            String firstSubstring = s.substring(0, i);
            if (hashSet.contains(firstSubstring)) {
                String remaining = s.substring(i);
                if (applyDFS(remaining, hashSet)) {
                    caching.put(s, true);
                    return true;
                }
            }
        }
        caching.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] wordDict = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        boolean b = new WordBreakI().wordBreak(s, Arrays.asList(wordDict));
        System.out.println(b);
    }
}
