package Coding.String;

import java.util.HashMap;

// https://leetcode.com/problems/palindrome-permutation/
// A string can be palindrome if it has only <= 1 odd number , otherwise its invalid
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (Character key : hashmap.keySet()) {
            int value = hashmap.get(key);

            if (value % 2 != 0) {
                if (count == 0) {
                    count++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean canPermutePalindromeUsingArr(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] % 2;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        String s = "code";
        boolean code = new PalindromePermutation().canPermutePalindrome("code");
        System.out.println(code);
    }
}
