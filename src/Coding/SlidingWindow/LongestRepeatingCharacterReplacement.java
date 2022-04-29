package Coding.SlidingWindow;

// revise
// todo
// https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int end = 0, start = 0, maxCount = 0;
        int arr[] = new int[256];
        int result = 0;
        while (end < s.length()) {
            arr[s.charAt(end)]++;
            maxCount = Math.max(maxCount, arr[s.charAt(end)]);
            end++;
            while (end - start - maxCount > k) {
                arr[s.charAt(start)]--;
                start++;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int i = new LongestRepeatingCharacterReplacement().characterReplacement(s, k);
        System.out.println(i);
    }
}
