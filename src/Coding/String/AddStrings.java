package Coding.String;

// https://leetcode.com/problems/add-strings/
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0 && num1.charAt(i) != '\0') {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0 && num2.charAt(j) != '\0') {
                sum += num2.charAt(j) - '0';
                j--;
            }
            builder.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
