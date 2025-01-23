package Meta;

// https://leetcode.com/problems/minimum-window-substring/
// Write a function that takes an input string and an alphabet, and returns the shortest substring of the
// input which contains every letter of the alphabet at least once.
// Example
// Input: "aaccbc"
// Alphabet: "abc"
// Output: "accb"
// https://leetcode.com/problems/minimum-window-substring/ - Pangram
// Time Complexity: O(n + m)
//Space Complexity: O(1)
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
            if (arr[val] > 0)
                count--; // Decrease count if character is part of the pattern
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
                if (arr[initialVal] > 0)
                    count++; // Increase count if character is part of the pattern
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength); // Return result
    }

    public static void main(String[] args) {
        String s = new MinimumWindowSubstring().minWindow("aaccbc", "abc");
        System.out.println(s);
    }
}
