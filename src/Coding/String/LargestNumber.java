package Coding.String;

import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num.length == 0) {
            return "";
        }
        String[] stringArray = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            stringArray[i] = String.valueOf(num[i]);
        }
        Arrays.sort(stringArray, (s1, s2) -> (s2 + s1).compareTo(s1 + s2)); // we can sort only string array
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (stringArray[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray)
            sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {54, 546, 548, 60};
        String s = new LargestNumber().largestNumber(arr);
        System.out.println(s);
    }
}
