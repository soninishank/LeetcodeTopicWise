package Coding.WordSeries;

import java.util.*;

// https://leetcode.com/problems/concatenated-words/
public class ConcatenatedWords {
    Map<String, Boolean> caching = new HashMap<>();
    List<String> list = new ArrayList<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (applyDFS(word, hashSet)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean applyDFS(String str, HashSet<String> wordDictionary) {
        if (caching.containsKey(str)) {
            return caching.get(str);
        }
        for (int i = 1; i <= str.length(); i++) {
            String firstSubstring = str.substring(0, i);
            if (wordDictionary.contains(firstSubstring)) {
                String remaining = str.substring(i); // iterate over the remaining string
                if (wordDictionary.contains(remaining) || applyDFS(remaining, wordDictionary)) {
                    caching.put(str, true);// if present - true
                    return true;
                }
            }
        }
        caching.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> allConcatenatedWordsInADict = new ConcatenatedWords().findAllConcatenatedWordsInADict(words);
        System.out.println(allConcatenatedWordsInADict);
    }
}
