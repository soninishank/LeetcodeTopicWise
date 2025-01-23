package Meta;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/357345/uber-phone-screen-sum-to-100
// https://leetcode.com/playground/HV2jmPMU
public class SumToTarget {

    private static final String DIGITS = "123456789";

    public static List<String> sumTo(int target) {
        List<String> result = new ArrayList<>();
        generate(0, 0, target, new StringBuilder(), result);
        return result;
    }

    private static void generate(int startIndex, int sum, int targetSum, StringBuilder path, List<String> result) {
        if (startIndex == DIGITS.length()) {
            if (sum == targetSum) {
                result.add(path.toString());
            }
            return;
        }
        int len = path.length();
        int num = 0;
        for (int i = startIndex; i < DIGITS.length(); i++) {
            num = 10 * num + DIGITS.charAt(i) - '0';

            if (startIndex != 0) {
                path.append('+');
            }
            path.append(num);
            generate(i + 1, sum + num, targetSum, path, result);
            // lets assume stringBuilder -> 1+2+3+4+5+6+7+8+9
            path.setLength(len);  // now it will be 1+2+3+4+5+6+7+8

            path.append('-');
            path.append(num);
            generate(i + 1, sum - num, targetSum, path, result);
            // lets assume stringBuilder -> 1+2+3+4+5+6+7+8-9
            path.setLength(len); // now it will be 1+2+3+4+5+6+7+8 -> used for removing + or - and number
        }
    }

    public static void main(String[] args) {
        List<String> strings = sumTo(100);
        System.out.println(strings);
    }
}
