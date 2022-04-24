package WordSeries;

import java.util.*;

// we need to make breakable sentences
// https://leetcode.com/problems/word-break-ii/
public class WordBreakII {


    // Just simply break in a recursive way
    HashMap<String, List<String>> hashMap = new HashMap<>();

    public List<String> wordBreakRecursive(String s, Set<String> wordDict) {
        if (hashMap.containsKey(s)) {
            return hashMap.get(s);
        }
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        if (wordDict.contains(s)) {
            result.add(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            String first = s.substring(0, i);
            if (wordDict.contains(first)) {
                List<String> subList = wordBreakRecursive(s.substring(i), wordDict);
                for (String sen : subList) {
                    result.add(first + " " + sen);
                }
            }
        }
        hashMap.put(s, result);// cache
        return result;
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        List<String> list = new WordBreakII().wordBreakRecursive(s, new HashSet<>(Arrays.asList(wordDict)));
        System.out.println(list);
    }
}
