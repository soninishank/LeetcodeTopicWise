package Coding.Meta;

import java.util.ArrayList;
import java.util.List;

public class MaximumDuplicateChars {

    public static List<Character> getMaxLengthDuplicateChars(String input) {
        List<Character> result = new ArrayList<>();

        if (input == null || input.isEmpty()) {
            return result; // Return an empty list if input is null or empty
        }

        char[] chars = input.toCharArray();
        int maxLength = 0;
        int currentLength = 1;

        // Loop through the string to find contiguous duplicate characters
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    result.clear();
                    result.add(chars[i - 1]);
                } else if (currentLength == maxLength) {
                    result.add(chars[i - 1]);
                }
                currentLength = 1;
            }
        }

        // Handle the last sequence - repeat the same steps
        if (currentLength > maxLength) {
            maxLength = currentLength;
            result.clear();
            result.add(chars[chars.length - 1]);
        } else if (currentLength == maxLength) {
            result.add(chars[chars.length - 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        String input1 = "aaaabbbbccc";
        String input2 = "abcd";

        System.out.println("Input: " + input1);
        System.out.println("Output: " + getMaxLengthDuplicateChars(input1));

        System.out.println("Input: " + input2);
        System.out.println("Output: " + getMaxLengthDuplicateChars(input2));
    }
}
