package Coding.SlidingWindow;

// https://leetcode.com/problems/minimum-window-substring/
// Its very simple - not at all hard
// Firstly make the pattern characters positive in 256 ascii array
// than iterating the str, and decrement it
public class MinimumWindowSubstring {
    public String minWindow(String s, String pattern) {
        int[] arr = new int[256]; // Frequency array for pattern characters
        // Populate the frequency array for the pattern
        for (int i = 0; i < pattern.length(); i++) {
            arr[pattern.charAt(i)]++;
        }
        int end = 0, start = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        int count = pattern.length(); // Count of remaining characters to match
        while (end < s.length()) {
            int val = s.charAt(end);
            if (arr[val] > 0) {
                count--; // Decrease count if character is part of the pattern
            }
            arr[val]--; // Decrement frequency
            end++;
            // Contract the window when a valid substring is found
            while (count == 0) {
                if (minLength > end - start) { // Update minimum substring details
                    minLength = end - start;
                    minStart = start;
                }
                int initialVal = s.charAt(start);
                arr[initialVal]++; // Restore frequency when moving 'start'
                // Because jo pattern me nahi honge vo toh negative me jayenge and plus karne
                // pe bhi vo 0 hi honge, 0 se aage nahi badhenge
                // but jo pattern me honge vo 1 ho jayenge
                if (arr[initialVal] > 0)
                    count++; // Increase count if character is part of the pattern
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength); // Return result
    }

    public static void main(String[] args) {
        String s = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);

        String s1 = new MinimumWindowSubstring().minWindow("ADOBECLMT", "ABC");
        System.out.println(s1);
    }
}
