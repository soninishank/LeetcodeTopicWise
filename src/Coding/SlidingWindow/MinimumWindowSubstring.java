package Coding.SlidingWindow;

// https://leetcode.com/problems/minimum-window-substring/
// Its very simple - not at all hard
// Firstly make the pattern characters positive in 256 ascii array
// than iterating the str, and decrement it
public class MinimumWindowSubstring {
    public String minWindow(String s, String pattern) {
        int[] arr = new int[256];
        // First mark the pattern
        for (int i = 0; i < pattern.length(); i++) {
            arr[pattern.charAt(i)]++;
        }
        int end = 0, start = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int count = pattern.length();
        while (end < s.length()) {
            int val = s.charAt(end);
            if (arr[val] > 0) {
                count--;
            }
            arr[val]--;
            end++;
            // it means you got the substring
            while (count == 0) {
                if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                int initialVal = s.charAt(start);
                arr[initialVal]++;
                // it means it belongs to the pattern
                // Because the ones that are not part of the pattern will become negative actually
                if (arr[initialVal] > 0) {
                    count++;
                }
                start++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return ""; // This is used to handle the case when "a","aa"
        } else {
            return s.substring(minStart, minStart + minLength);
        }
    }

    public static void main(String[] args) {
        String s = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);

        String s1 = new MinimumWindowSubstring().minWindow("ADOBECLMT", "ABC");
        System.out.println(s1);
    }
}
