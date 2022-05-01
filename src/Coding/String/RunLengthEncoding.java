package Coding.String;

// https://leetcode.com/discuss/interview-question/124996/tag/8/facebook/
public class RunLengthEncoding {

    private String compressString(String str) {
        if (str.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int end = 0;
        while (end < str.length()) {
            char c = str.charAt(end);
            stringBuilder.append(c);
            end++;
            int count = 1;
            while (end < str.length() && str.charAt(end) == c) {
                count++;
                end++;
            }
            if (count > 1) {
                stringBuilder.append(count);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String result = new RunLengthEncoding().compressString("abcccddeeeeea");
        System.out.println(result);
    }
}
