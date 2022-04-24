package DynamicProgramming.Grid;

public class LongestPalindromicSubstring {
    // https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        String result = "";
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); j++, i++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                } else if (gap > 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
                if (dp[i][j] == 1) {
                    String subStr = s.substring(i, j + 1);
                    if (subStr.length() > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String babad = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(babad);
    }
}
