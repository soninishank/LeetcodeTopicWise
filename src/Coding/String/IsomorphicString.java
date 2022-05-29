package Coding.String;

// https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[26];
        int[] m2 = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i) - 'a'] != m2[t.charAt(i) - 'a']) {
                return false;
            }
            m1[s.charAt(i) - 'a'] = i + 1;
            m2[t.charAt(i) - 'a'] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        boolean isomorphic = new IsomorphicString().isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
