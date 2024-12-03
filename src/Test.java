public class Test {
    public String minWindow(String s, String pattern) {
        int minLength = Integer.MAX_VALUE, minStart = 0;
        int start = 0, end = 0;
        int[] arr = new int[256];
        for (int i = 0; i < pattern.length(); i++) {
            arr[pattern.charAt(i) ]++;
        }
        int count = pattern.length();

        char[] str = s.toCharArray();
        while (end < str.length) {
            if (arr[str[end]] > 0) {
                count--;
            }
            arr[str[end]]--;
            end++;

            while (count == 0) {
                if (end - start < minLength) {
                    minStart = start;
                    minLength = end - start;
                }
                arr[str[start]]++;
                if (arr[str[start]] > 0) {
                    count++;
                }
                start++;
            }
        }
        return s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String p = "ABC";
        String intersect = new Test().minWindow(s, p);
        System.out.println(intersect);
    }
}
