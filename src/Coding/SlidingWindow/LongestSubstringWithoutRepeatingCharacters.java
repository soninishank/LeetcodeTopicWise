package Coding.SlidingWindow;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// s consists of English letters, digits, symbols and spaces.
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int end = 0, start = 0, result = 0;
        while (end < s.length()) {
            arr[s.charAt(end)]++;
            while (arr[s.charAt(end)] > 1) {
                arr[s.charAt(start)]--;
                start++;
            }
            end++;
            result = Math.max(result, end - start);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        int i = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(str);
        System.out.println(i);
    }
}
