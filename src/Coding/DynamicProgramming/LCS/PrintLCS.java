package Coding.DynamicProgramming.LCS;

public class PrintLCS {
    private String longestCommonSubsequencePrint(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        return validateUsingDP(str1, str2, str1.length(), str2.length());
    }

    private String validateUsingDP(String str1, String str2, int n, int m) {
        int[][] mat = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    mat[i][j] = 1 + mat[i - 1][j - 1];
                } else {
                    int v1 = mat[i][j - 1];
                    int v2 = mat[i - 1][j];
                    mat[i][j] = Math.max(v1, v2);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String i = new PrintLCS().longestCommonSubsequencePrint("abcde", "ace");
        System.out.println(i);
    }


}
