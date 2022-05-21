package Coding.SlidingWindow;

// revise
// todo
// https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] cArr = new int[26];
        int maxCount = 0, start = 0, maxSize = 0;
        int end = 0;
        while (end < s.length()) {
            int index = s.charAt(end) - 'A';
            cArr[index]++;
            maxCount = Math.max(maxCount, cArr[index]);
            end++;
            if (end - start - maxCount > k) {
                cArr[s.charAt(start) - 'A']--;
                start++;
            }
            maxSize = Math.max(maxSize, end - start);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int i = new LongestRepeatingCharacterReplacement().characterReplacement(s, k);
        System.out.println(i);
    }
}
