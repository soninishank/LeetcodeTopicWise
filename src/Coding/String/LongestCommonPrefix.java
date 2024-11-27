package Coding.String;

// https://leetcode.com/problems/longest-common-prefix/
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

    // when you do the dry run, you will understand it.
    // Example of How indexOf Works Here
    //If strs[i] is "flower" and prefix is "flowing", strs[i].indexOf("flowing") would return -1
    // because "flower" does not contain "flowing". The while loop would then shorten prefix to "flowin", "flowi", "flow",
    // until it finds a match or prefix is empty.
    public String longestCommonPrefixStr(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Start with the first string as the initial prefix
        String prefix = strs[0];
        // Compare the current prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix,
            // shorten the prefix
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If the prefix becomes empty, return ""
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{"nish", "nishu", "nipuja"});
        System.out.println(s);

        String s1 = new LongestCommonPrefix().longestCommonPrefixStr(new String[]{"flower", "flow", "flight"});
        System.out.println(s1);
    }
}
