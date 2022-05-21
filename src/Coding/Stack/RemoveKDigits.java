package Coding.Stack;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {

    Stack<Integer> stack = new Stack<>();

    public String removeKDigits(String num, int k) {
        char[] arr = num.toCharArray();
        //corner case
        if (k == num.length()) {
            return "0";
        }
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] - '0';
            if (stack.isEmpty()) {
                stack.push(val);
            } else if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() > val && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(val);
            }
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String s = new RemoveKDigits().removeKDigits("10200", 1);
        System.out.println(s);
    }
}
