package Coding.SlidingWindow;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] arr = new int[256];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }
        int end = 0, start = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length();
        while (end < s.length()) {
            int val = s.charAt(end);
            if (arr[val] > 0) {
                count--;
            }
            arr[val]--;
            end++;
            while (count == 0) {
                if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                int initialVal = s.charAt(start);
                arr[initialVal]++;
                if (arr[initialVal] > 0) {
                    count++;
                }
                start++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minStart, minStart + minLength);
        }
    }

    public static void main(String[] args) {
        String s = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
