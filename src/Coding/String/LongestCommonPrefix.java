package Coding.String;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }
        String str1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String newStr = strs[i];
            int j = 0;
            while (j < minLength) {
                if (str1.charAt(j) == newStr.charAt(j)) {
                    j++;
                } else {
                    minLength = j;
                    break;
                }
            }
        }
        return str1.substring(0, minLength);
    }

    public static void main(String[] args) {
        String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{"nish","nishu","nipuja"});
        System.out.println(s);
    }
}
