package Coding.Stack;

public class DecodeString {
    private String decodeString(String str, int index) {
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        int k = 0;
        while (index < chars.length) {
            if (Character.isDigit(chars[index])) {
                while (index < str.length() && Character.isDigit(chars[index])) {
                    k = k * 10 + chars[index] - '0';
                    index++;
                }
            } else if (Character.isAlphabetic(chars[index])) {
                result.append(chars[index]);
                index++;
            } else if (chars[index] == ']') {
                index++;
                return result.toString();
            } else if (chars[index] == '[') {
                index++;
                String tempResult = decodeString(str, index);
                // we need to append this K times
                while (k > 0) {
                    result.append(tempResult);
                    k--;
                }
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String s = new DecodeString().decodeString("3[a]2[bc]", 0);
        System.out.println(s);
    }
}
