package Coding.String;

import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        String[] stringArray = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            stringArray[i] = String.valueOf(num[i]);
        }
        Arrays.sort(stringArray, (s1, s2) -> (s1 + s2).compareTo(s2 + s1)); // we can sort only string array
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (stringArray[0].charAt(0) == '0')
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray)
            sb.append(s);
        return sb.toString();
    }
}
