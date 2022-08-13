package Coding.Recursion.LCS;

public class LongestCommonSubsequence {
    static int lcs(int x, int y, String s1, String s2) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (s1.charAt(x) == s2.charAt(y)) {
            return 1 + lcs(x - 1, y - 1, s1, s2);
        } else {
            int val1 = lcs(x - 1, y, s1, s2);
            int val2 = lcs(x, y - 1, s1, s2);
            return Math.max(val1, val2);
        }
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        // GTAB
        int lcs = lcs(s1.length() - 1, s2.length() - 1, s1, s2);
        System.out.println(lcs);
    }
}
