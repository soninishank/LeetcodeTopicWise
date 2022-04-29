package Coding.String;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                String substring = s.substring(i, j + 1);
                System.out.println(substring);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "abc";
        int i = new PalindromicSubstrings().countSubstrings(s);
        System.out.println(i);
    }
}
