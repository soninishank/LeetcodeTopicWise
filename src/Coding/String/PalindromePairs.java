package Coding.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/palindrome-pairs/
public class PalindromePairs {
    List<List<Integer>> result = new ArrayList<>();
    HashMap<String, Integer> hashMap = new HashMap<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            hashMap.put(words[i], i);
        }
        // empty string case
        if (hashMap.containsKey("")) {
            int index = hashMap.get("");
            for (int i = 0; i < words.length; i++) {
                if (i != index && isPalindrome(words[i])) {
                    result.add(new ArrayList<>(Arrays.asList(i, index)));
                    result.add(new ArrayList<>(Arrays.asList(index, i)));
                }
            }
        }
        // Reflection case
        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            Integer reverseIndex = hashMap.get(reverse);
            if (reverseIndex != null && i != reverseIndex) {
                result.add(new ArrayList<>(Arrays.asList(i, reverseIndex)));
            }
        }
        // Tricky case
        // s1 - abade
        // s2 - ed
        // s1+s2 -> abadeed -> not a palindrome
        // s2+s1 -> edabade -> a palindrome - let's deep dive
        // firstPart = aba  remainingPart = de
        // so firstPart is palindrome and remainingPart is a reflection of s2
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            for (int j = 1; j < current.length(); j++) {
                String firstPart = current.substring(0, j);
                String remainingPart = current.substring(j);
                if (isPalindrome(firstPart)) {
                    String reverseRight = new StringBuilder(remainingPart).reverse().toString();
                    if (hashMap.containsKey(reverseRight)) {
                        int indexRight = hashMap.get(reverseRight);
                        result.add(new ArrayList<>(Arrays.asList(indexRight, i)));
                    }
                }
                if (isPalindrome(remainingPart)) {
                    String reverseLeft = new StringBuilder(firstPart).reverse().toString();
                    if (hashMap.containsKey(reverseLeft)) {
                        int indexLeft = hashMap.get(reverseLeft);
                        result.add(new ArrayList<>(Arrays.asList(indexLeft, i)));
                    }
                }
            }
        }
        return result;
    }


    private boolean isPalindrome(String str1) {
        int low = 0, high = str1.length() - 1;
        while (low <= high) {
            if (str1.charAt(low) == str1.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] str = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> list = new PalindromePairs().palindromePairs(str);
        System.out.println(list);
    }
}
