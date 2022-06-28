package Coding.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagrams {
    int[] arr = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            int temp = p.charAt(i) - 'a';
            arr[temp]--;
        }
        int end = 0, start = 0;
        while (end < s.length()) {
            int endTemp = s.charAt(end) - 'a';
            arr[endTemp]++;
            end++;
            if (end - start > p.length()) {
                int startTemp = s.charAt(start) - 'a';
                arr[startTemp]--;
                start++;
            }
            if (end - start == p.length() && doValidation()) {
                list.add(start);
            }
        }
        return list;
    }

    private boolean doValidation() {
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
