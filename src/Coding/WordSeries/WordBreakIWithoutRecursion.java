package Coding.WordSeries;

import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/word-break/
// 139. Word Break
public class WordBreakIWithoutRecursion {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        HashSet<String> hashSet = new HashSet<>();
        for (String ste : wordDict) {
            hashSet.add(ste);
        }
        return checkWordBreak(s, hashSet);
    }

    private boolean checkWordBreak(String str, HashSet<String> hashSet) {
        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(0, i + 1);
            if (hashSet.contains(substring)) {
                String remainingSubstr = str.substring(i+1);
                if (checkWordBreak(remainingSubstr, hashSet)) {
                    return true;
                }
            }
        }
        return false;
    }
}
