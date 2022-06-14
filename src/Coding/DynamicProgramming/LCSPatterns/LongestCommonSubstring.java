package Coding.DynamicProgramming.LCSPatterns;

// https://leetcode.com/discuss/interview-question/1273766/longest-common-substring
// https://leetcode.com/discuss/interview-question/1273766/longest-common-substring
public class LongestCommonSubstring {

    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        return longestCommonSubstringUsingDP(nums1, nums2, nums1.length, nums2.length);
    }

    private int longestCommonSubstringUsingDP(int[] nums1, int[] nums2, int first, int second) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;
        for (int i = 0; i <= first; i++) {
            for (int j = 0; j <= second; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        int length = new LongestCommonSubstring().findLength(nums1, nums2);
        System.out.println(length);
    }
}
