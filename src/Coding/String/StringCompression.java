package Coding.String;

// TODO
// https://leetcode.com/problems/string-compression/
// good question
// you need to modify the array
// unable to do on a first place
public class StringCompression {

    public int compress(char[] chars) {
        int end = 0;
        int indexAns = 0;
        while (end < chars.length) {
            char currentChar = chars[end];
            int count = 0;
            while (end < chars.length && chars[end] == currentChar) {
                end++;
                count++;
            }
            chars[indexAns] = currentChar;
            indexAns++;
            if (count > 1) {
                char[] chars1 = String.valueOf(count).toCharArray();
                for (int i = 0; i < chars1.length; i++) {
                    chars[indexAns] = chars1[i];
                    indexAns++;
                }
            }
        }
        return indexAns;
    }

    public static void main(String[] args) {
        char[] str = {'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        int compress = new StringCompression().compress(str);
        System.out.println(compress);
    }
}
