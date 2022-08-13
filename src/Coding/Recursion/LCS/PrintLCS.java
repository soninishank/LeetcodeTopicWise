package Coding.Recursion.LCS;

public class PrintLCS {
    static void lcs(int x, int y, String s1, String s2) {
        if (x < 0 || y < 0) {
            return;
        }
        if (s1.charAt(x) == s2.charAt(y)) {
            lcs(x - 1, y - 1, s1, s2);
        } else {
            lcs(x - 1, y, s1, s2);
            lcs(x, y - 1, s1, s2);
        }
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        // GTAB
        lcs(s1.length() - 1, s2.length() - 1, s1, s2);
    }
}
