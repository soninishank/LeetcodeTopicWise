package Coding.SlidingWindow;

// https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {
    int[] arr = new int[26];

    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }
        int end = 0, start = 0;
        while (end < s2.length()) {
            arr[s2.charAt(end) - 'a']--;
            end++;
            if (end - start > s1.length()) {
                arr[s2.charAt(start) - 'a']++;
                start++;
            }
            if (end - start == s1.length()) {
                if (doValidation()) {
                    return true;
                }
            }
        }
        return doValidation();
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
        boolean b = new PermutationInString().checkInclusion("ab", "eidboaoo");
        System.out.println(b);
    }
}
