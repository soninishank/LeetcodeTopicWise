package Coding.SlidingWindow;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// s consists of English letters, digits, symbols and spaces.
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int end = 0, start = 0, result = 0;
        int[] arr = new int[256];
        int max = 0;
        while (end < s.length()) {
            int c1 = s.charAt(end);
            arr[c1]++;
            end++;
            while (arr[c1] > 1) {
                int c2 = s.charAt(start);
                arr[c2]--;
                start++;
            }
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
