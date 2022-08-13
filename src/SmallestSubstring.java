import java.util.ArrayList;
import java.util.List;

public class SmallestSubstring {

    private String getStringDetails(char[] t, String s) {
        int[] arr = new int[256];
        for (int i = 0; i < t.length; i++) {
            arr[t[i]]++;
        }
        int end = 0, start = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length;
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

    private final List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        doBacktrack(n, 0, 0, "");
        return result;
    }

    void doBacktrack(int n, int open, int close, String str) {
        if (n * 2 == str.length()) {
            result.add(str);
            return;
        }
        if (open < n) {
            doBacktrack(n, open + 1, close, str + "(");
        }
        if (close < open) {
            doBacktrack(n, open, close + 1, str + ")");
        }
    }

    public static void main(String[] args) {
//        char[] arr = {'x', 'y', 'z'};
//        String str = "xyyzyzyx";
//        String test = new SmallestSubstring().getStringDetails(arr, str);
//        System.out.println(test);


        List<String> list = new SmallestSubstring().generateParenthesis(3);
        System.out.println(list);

    }
}
