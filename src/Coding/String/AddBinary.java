package Coding.String;

// https://leetcode.com/problems/add-binary/
public class AddBinary {
    public String addBinary(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String s = new AddBinary().addBinary(a, b);
        System.out.println(s);
    }
}
