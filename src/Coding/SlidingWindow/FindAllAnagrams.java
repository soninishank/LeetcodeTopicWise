package Coding.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    int[] arr = new int[26];

    List<Integer> resultList = new ArrayList<>();

    public List<Integer> findAnagrams(String s, String p) {
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']--;
            if (i - start >= p.length() - 1) {
                if (checkIsPattern()) {
                    resultList.add(start);
                }
            }
            if (i - start > p.length() - 1) {
                arr[s.charAt(start) - 'a']++;
            }
        }
        return resultList;
    }

    boolean checkIsPattern() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        List<Integer> anagrams = new FindAllAnagrams().findAnagrams(s, p);
        System.out.println(anagrams);
    }
}

// abab
// ab
// ++
